package com.problems.epi.code.binary_trees.learning;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * This iteratively traverses a tree in three different orders using a stack
 * Time complexity: O(n)
 * Space Complexity: O(logn); in worst case (skewed tree): O(n)
 */
public class TreeTraversal_Iterative_WithStack {

    // The idea behind this method is:
    // the current node is printed first, then left subtree is processed first,
    // then the right subtree is processed.
    // Algorithm is:
    //  1) Push the current node to stack
    //	2) Print the current node.
    //  3) Process left first by pushing right node before left node
    public static List<Integer> preOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.data);
            // Process left first by pushing right node before left node
            if(root.right != null) stack.push(root.right); // !important
            if(root.left != null) stack.push(root.left);  // !important
        }
        return  res;
    }

    /**
     * Algorithm
     1) Create an empty stack S.
     2) Initialize current node as root
     3) Push the current node to S and set current = current->left until current is NULL (pushAllLeft(...))
     4) If stack is not empty then
        a) Pop the top item from stack.
        b) Print the popped item,
        c) Check if current has a right child
            i) Yes -> set current = popped_item->right and Perform step 3
            ii) No -> continue
     */
    public static List<Integer> inOrder(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode<Integer> curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushAllLeft(curr, stack);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.data);
            if(curr.right != null) {
                curr = curr.right;
                pushAllLeft(curr, stack);
            }
        }
        return  res;
    }

    public static List<Integer> inOrder_MoreCompact(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // Push left subtree to the stack
            while (root != null) {
                stack.offerFirst(root); // can use push() too
                root = root.left;
            }
            root = stack.removeFirst(); // can use pop() too
            res.add(root.data);
            root = root.right;
        }
        return res;
    }

    // The idea behind this method is from the iterative inorder
    // where the left subtree is processed first, the node printed,
    // then the right subtree is processed. However, in this postorder,
    // the left subtree is processed first, then the right is processed,
    // then the node if visited
    /**
     * Algorithm
     1) Create an empty stack S.
     2) Initialize current node as root
     3) Push the current node to S and set current = current->left until current is NULL (pushAllLeft(...))
     4) If stack is not empty then
        a) Pop the top item from stack.
        b) Print the popped item,
        c) Check if current's right child has been visited
        d) No -> set current = popped_item->right and Perform step 3
        e) Yes -> print and delete node from stack and set prev to the deleted node
     */
    public static List<Integer> postOrderWithOneStack(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode<Integer> curr = root;
        // Push all nodes in the leftmost subtree to the stack
        pushAllLeft(curr, stack);
        while(!stack.isEmpty()) {
            curr = stack.peek();
            // Check if the right subtree has been traversed
            // i.e. if the previous node was a right child
            if(curr.right != null && curr.right != prev) {
                curr = curr.right;
                pushAllLeft(curr, stack);
            }
            else {
                res.add(curr.data);
                prev = stack.pop();
            }
        }
        return res;
    }

    // The idea behind the algorithm is the same idea for preorder except:
    //	1) Process right first by pushing left node before right node
    //	2) Instead of printing the node, push it to stack 2 (use stack 1 as primary stack).
    //	3) Pop and print elements from stack 2.
    public static void postOrderWithTwoStacks(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(root);
        while(!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if(root.left != null) s1.push(root.left);
            if(root.right != null) s1.push(root.right);
        }
        while(!s2.isEmpty()) System.out.println(s2.pop());
    }

    private static void pushAllLeft(TreeNode root, Deque<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
