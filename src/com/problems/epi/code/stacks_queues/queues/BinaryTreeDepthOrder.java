package com.problems.epi.code.stacks_queues.queues;

import com.util.TreeNode;

import java.util.*;

public class BinaryTreeDepthOrder {

    /**
     * Key Insight: Since it is a breadth first search type problem- think of a queue.
     * How can we know when a level has been completed?
     * Answer- For each level get the size of the number of nodes at the level
     * and process all nodes at that level using the for loop
     */
    public List<List<Integer>> binaryTreeDepthOrder(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.pollFirst();
                list.add((Integer) n.data);
                if (n.left != null) queue.offerLast(n.left);
                if (n.right != null) queue.offerLast(n.right);
            }
            result.add(list);
        }
        return result;
    }
}
