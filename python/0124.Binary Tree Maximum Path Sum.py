"""
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.ans = root.val
        self.helper(root)
        return self.ans
    
    def helper(self, root):
        if not root: return 0
        left = max(0, self.helper(root.left))
        right = max(0, self.helper(root.right))
        self.ans = max(self.ans, left + right + root.val)
        return max(left, right) + root.val