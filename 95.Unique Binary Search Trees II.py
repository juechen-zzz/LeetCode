"""
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        cache = {}

        def generateTrees(start, end):
            print("start: " + str(start) + " - end: " + str(end))
            if start > end:
                return [None]

            if str((start,end)) in cache:
                return cache[str((start,end))]


            all_trees = []
            for i in range(start, end + 1):
                left_trees = generateTrees(start, i - 1)
                right_trees = generateTrees(i + 1, end)

                for l in left_trees:
                    for r in right_trees:
                        current_tree = TreeNode(i)
                        current_tree.left = l
                        current_tree.right = r
                        all_trees.append(current_tree)
            cache[str((start,end))] = all_trees
            return all_trees

        return generateTrees(1, n) if n else []