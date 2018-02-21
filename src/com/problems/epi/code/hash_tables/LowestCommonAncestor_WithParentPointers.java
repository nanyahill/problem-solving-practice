package com.problems.epi.code.hash_tables;

import com.util.TreeNode;

import java.util.HashSet;

/** Problem Type: Trees/HashTables
 Pattern: HashTable
 Key Insight:
 - Access to the parent pointer is available.
 - Problem asks to solve the problem in time complexity proportional to the distance from the nodes to LCA.
 - This means that we need to store all parents of each node until the parent of one node is already present in the other node.
   What DS can be used to store these nodes? (Think HashTable because lookup and insert is fast).
 - For this problem, a hashset will suffice because we are storing the distinct parents of each node.
   The moment we get a duplicate parent, we have our answer!
 */
public class LowestCommonAncestor_WithParentPointers {
    public static TreeNode findLCA(TreeNode n1, TreeNode n2) {
        if(n1 == n2 || (n1 == null || n2 == null)) return null;
        HashSet<TreeNode> parentSet = new HashSet<>();
        while(n1.parent != null && n2.parent != null) {
            if(!parentSet.add(n1.parent) && !parentSet.add(n2.parent))
                return parentSet.contains(n1.parent) ? n1.parent : n2.parent;
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1.parent == null ? n1 : n2;
    }
}
