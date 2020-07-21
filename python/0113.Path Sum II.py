'''
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self, root, target, items, res):
        if not root: return
        if not root.left and not root.right and root.val == target:
            res.append(items + [root.val])
            return
        items.append(root.val)
        self.helper(root.left, target-root.val, items, res)
        self.helper(root.right, target-root.val, items, res)
        items.pop()

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        self.helper(root, sum, [], res)
        return res