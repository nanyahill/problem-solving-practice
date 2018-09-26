package com.problems.ctci.chapter4;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question4_12 {

    public static int countPaths_ParentToChild(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPaths_ParentToChild(root, target, 0, map);
    }

    private static int countPaths_ParentToChild(TreeNode<Integer> root, int target, int currSum, Map<Integer, Integer> map) {
        if (root == null) return 0;
        currSum += root.data;
        int totalPaths = map.getOrDefault(currSum - target, 0);
        //map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        incrementHashTable(map, currSum, 1);
        totalPaths += countPaths_ParentToChild(root.left, target, currSum, map);
        totalPaths += countPaths_ParentToChild(root.right, target, currSum, map);
        //map.put(currSum, map.getOrDefault(currSum, 0) - 1);
        incrementHashTable(map, currSum, -1);
        return totalPaths;
    }

    private static void incrementHashTable(Map<Integer, Integer> map, int key, int delta) {
        int newCount = map.getOrDefault(key, 0) + delta;
        if (newCount == 0) map.remove(key);
        else map.put(key, newCount);
    }
}
