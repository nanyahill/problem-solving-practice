package com.problems.ctci.chapter4;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question4_9 {

    public static List<LinkedList<Integer>> findAllSequences(TreeNode<Integer> root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if(root == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.data);
        List<LinkedList<Integer>> leftList = findAllSequences(root.left);
        List<LinkedList<Integer>> rightList = findAllSequences(root.right);
        for(LinkedList<Integer> left : leftList) {
            for(LinkedList<Integer> right : rightList) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static void weaveLists(LinkedList<Integer> left, LinkedList<Integer> right, List<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {
        if(left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> tmp = new LinkedList<>(prefix);
            tmp.addAll(left);
            tmp.addAll(right);
            weaved.add(tmp);
            return;
        }
        // Left List
        Integer headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        left.addFirst(headLeft);

        // Right List
        Integer headRight = right.removeFirst();
        prefix.addLast(headRight);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        right.addFirst(headRight);
    }
}
