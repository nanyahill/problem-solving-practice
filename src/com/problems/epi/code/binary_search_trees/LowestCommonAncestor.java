package com.problems.epi.code.binary_search_trees;

import com.util.TreeNode;

/**
 * Notes to keep in mind: Remember the definition, it is important!
 * Especially that if one node is the ancestor of the second node then that node is the LCA.
 * Wikipedia Definition: LCA of v and w nodes is the lowest node that has nodes, v and w as descendants.
 * If v has a direct connection from w, then w is the LCA.
 * In general, LCA problems boils down to finding the location of n1 and n2.
 * In terms of interviews, the question could be applied to binary trees (with or without parent pointers) or binary search trees. We will look at the the various key ideas for each:

Key Ideas:
 The inherent property of BST makes this problem much easier to handle. Key insights for the solution is:
 - locating n1 and n2 in a BST is pretty easy.
 - there are 4 cases to this problem:
 a) Both nodes are in the different subtrees (return the current node)
 b) One of the nodes is in the search path of the second node (see definition of LCA- wikipedia) (i.e. return the current node)
 c) Both nodes are in the left subtree (i.e. current node is greater than the max of n1 and n2)
 d) Both nodes are in the right subtree (i.e. current node is less than the min of n1 and n2)
 Time Complexity: O(h) and Space complexity: O(1) (may be worse because of recursion stack)
 */
public class LowestCommonAncestor {
    // LCA in BST Iterative method
    // Time Complexity: O(h), Space Complexity: O(1)
    public static TreeNode findLCAInBST_Iterative(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == null || q == null) return null;
        TreeNode lca = null;
        while (root != null) {
            if (root.data > Math.max(p.data, q.data)) root = root.left;
            else if (root.data < Math.min(p.data, q.data)) root = root.right;
            else {
                // root < max and root > min: max > root > min
                lca = root;
                break;
            }
        }
        return lca;
    }

    // LCA in BST Recursive method
    // Time Complexity: O(h), Space Complexity: O(1)
    public static TreeNode findLCAInBST_Recursive(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == null || q == null) return null;
        if (root.data > Math.max(p.data, q.data)) return findLCAInBST_Recursive(root.left, p, q);
        else if (root.data < Math.min(p.data, q.data)) return findLCAInBST_Recursive(root.right, p, q);
        else return root;
    }
}
