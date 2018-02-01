package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This iteratively traverses a tree in three different orders assuming each node has reference to its parent
 * Time complexity: O(n)
 * Space Complexity: O(1) but extra space is used by each node storing its parent
 */
public class TreeTraversal_Iterative_WithParentPointers {

    public static List<Integer> preOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode<Integer> curr = root, prev = null, next;
        while (curr != null) {
            if (curr.parent == prev) {
                res.add(curr.data);
                next = curr.left;
                if (next == null) {
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                next = (curr.right != null) ? curr.right : curr.parent;
            } else next = curr.parent;
            prev = curr;
            curr = next;
        }
        return res;
    }

    public static List<Integer> inOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode<Integer> curr = root, prev = null, next;
        while(curr != null) {
            if(curr.parent == prev) {
                next = curr.left;
                if(next == null) { // done with left side
                    res.add(curr.data);
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            }
            else if(curr.left == prev) { // moving to right side
                res.add(curr.data);
                next = (curr.right != null) ? curr.right : curr.parent;
            }
            else next = curr.parent;
            prev = curr;
            curr = next;
        }
        return res;
    }

    public static List<Integer> postOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode<Integer> curr = root, prev = null, next;
        while(curr != null) {
            if(curr.parent == prev) {
                next = curr.left;
                if(next == null) { // done with left side
                    next = (curr.right != null) ? curr.right : curr.parent;
//                    if(next == curr.parent) { // done with right side
//                        res.add(curr.heap);
//                    }
                }
            }
            else if(curr.left == prev) { // moving to right side
                next = (curr.right != null) ? curr.right : curr.parent;
//                if(next == curr.parent) { // done with right side
//                    res.add(curr.heap);
//                }
            }
            else {
                //res.add(curr.heap);
                next = curr.parent;
            }
            // This can also be placed as per commented code above
            if(next == curr.parent) res.add(curr.data);
            prev = curr;
            curr = next;
        }
        return res;
    }
}
