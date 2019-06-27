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

class Solution(object):
    def pathSum(self, root, target):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        res = []
        self.check(root,target,[],res)
        return res
    
    def check(self,root,target,items,res):
        if not root:
            return
        
        if not root.left and not root.right and root.val == target:
            res.append(items + [root.val])
            return
        
        items.append(root.val)
        self.check(root.left,target - root.val,items,res)
        self.check(root.right,target - root.val,items,res)
        items.pop()