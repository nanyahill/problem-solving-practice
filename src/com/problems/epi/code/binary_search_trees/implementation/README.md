Search: O(h) for unbalanced; h = logn for balanced; h = n for skewed tree
Insert: O(h)
Delete:

If deletions are allowed, the BST can quickly become symmetric.

What is a BST?
BSt implementation?
Common Operations of BST?
When is it most applicable?

Definition
A binary search tree is a binary tree that contains key-value pairs called nodes where each node satisfies the binary search property:
    - the left subtree of a node contains nodes whose keys are less than the node's key
    - the right subtree of a node contains nodes whose keys are greater than the node's key

Properties
- Every BST starts with a node at the top, called the root.
- BSTs are defined recursively.
- BST implementations are started with a class for the node abstraction, which has a reference to the key, value, left node and right node.
- Keys must be comparable because of the bst property that needs to be maintained.
- Values are arbitrary and may/may not be present.

Performance of Common Algorithms on BST
- Search: Avg Case: O(logn); Worst Case: O(n)
- Traverse: Avg Case & Worst Case: O(n)
- Insert: Avg Case: O(logn); Worst Case: O(n)
- Delete: Avg Case: O(logn); Worst Case: O(n)
- Minimum: Avg Case: O(logn); Worst Case: O(n)
- Maximum: Avg Case: O(logn); Worst Case: O(n)
Note: The running times of algorithms on binary search trees depend on the shapes of the trees, which, in turn, depends on the order in which keys are inserted.

Not Obvious Facts:
- Inorder traversal of BST always produces sorted output.
- We can construct a BST with only Preorder or Postorder or Level Order traversal.
- There is no need to traverse tree to get inorder traversal- it can always be obtained by sorting the only given traversal.
- Number of unique BSTs with n distinct keys is Catalan Number
- When inserting a new node to a BST, after insertion, the new node would be a leaf node.
- When deleting a node with two children from a BST, when the node is found its successor must only have one child (i.e. a right child) (Note if it had a left child then that child should be the successor).

BST vs HashTables
Similarities
- They are used to as two different implementations of dictionaries.
- HashTables are a more practical way to maintain a dictionary because they expolit the fact that looking up an item in an
array takes constant time once you have the index.

