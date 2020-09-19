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
    def max_sum(self, root):
        if not root: return 0
        sum1 = self.max_sum(root.left) + root.val
        sum2 = self.max_sum(root.right) + root.val
        sum3 = sum1 + sum2 - root.val
        sum4 = root.val
        self.ans = max(self.ans, sum1, sum2, sum3, sum4)
        return max(sum1, sum2, sum4)

    def maxPathSum(self, root: TreeNode) -> int:
        self.ans = root.val
        self.max_sum(root)
        return self.ans
    