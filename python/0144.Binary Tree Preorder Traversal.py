'''
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None



# Recursive solution
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def dfs(node):
            if not node:
                return
            pre_order.append(node.val)
            dfs(node.left)
            dfs(node.right)
        
        pre_order = []
        dfs(root)
        return pre_order



# Iterative solution
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        pre_order = []
        stack = [root]
        while stack:
            top = stack.pop()
            pre_order.append(top.val)
            if top.right:
                stack.append(top.right)
            if top.left:
                stack.append(top.left)
        return pre_order