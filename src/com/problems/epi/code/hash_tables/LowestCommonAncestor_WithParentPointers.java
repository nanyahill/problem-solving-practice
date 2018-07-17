package com.problems.epi.code.hash_tables;

import com.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/** Problem Type: Trees/HashTables
 Pattern: HashTable
 Key Insight:
 - Access to the parent pointer is available.
 - Problem asks to solve the problem in time complexity proportional to the distance from the nodes to LCA.
 - This means that we need to store all parents of each node until the parent of one node is already present in the other node.
   What DS can be used to store these nodes? (Think HashTable because lookup and insert is fast).
 - For this problem, a hashset will suffice because we are storing the distinct parents of each node.
   The moment we get a duplicate parent, we have our answer!
 - Time & Space Complexity: O(d1 + d2) where d1 = distance of node1 to LCA, d2 = distance of node2 to LCA
 */
public class LowestCommonAncestor_WithParentPointers {
    public static TreeNode findLCA(TreeNode n1, TreeNode n2) {
        Set<TreeNode> parentSet = new HashSet<>();
        while(n1 != null || n2 != null) {
            if (n1 != null) {
                if (!parentSet.add(n1)) return n1;
                n1 = n1.parent;
            }
            if (n2 != null) {
                if (!parentSet.add(n2)) return n2;
                n2 = n2.parent;
            }
        }
        return null; // nodes are in different trees.
    }
}
