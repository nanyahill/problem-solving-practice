package com.problems.more_epi_related_practice.code.binary_trees;

import com.util.TreeNode;

import java.util.*;

public class TreeVerticalOrderTraversal {
    static class QueueEntry {
        int colIdx;
        TreeNode<Integer> node;

        public QueueEntry(int colIdx, TreeNode<Integer> node) {
            this.colIdx = colIdx;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<QueueEntry> queue = new ArrayDeque<>();
        queue.add(new QueueEntry(0, root));
        int minColIdx = 0;
        int maxColIdx = 0;
        while (!queue.isEmpty()) {
            QueueEntry entry = queue.remove();
            TreeNode<Integer> node = entry.node;
            int colIdx = entry.colIdx;
            if (map.containsKey(colIdx)) {
                map.get(colIdx).add(node.data);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(node.data);
                map.put(colIdx, tmp);
            }
            if (node.left != null) {
                queue.add(new QueueEntry(colIdx - 1, node.left));
                minColIdx = Math.min(minColIdx, colIdx - 1);
            }
            if (node.right != null) {
                queue.add(new QueueEntry(colIdx + 1, node.right));
                maxColIdx = Math.max(maxColIdx, colIdx + 1);
            }
        }
        for(int i = minColIdx; i <= maxColIdx; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
