'''
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:     
        def helper(root,lst):
            if not root: 
            	return
            helper(root.left,lst)
            lst.append(root.val)
            helper(root.right,lst)
        
        lst = []
        helper(root,lst)
        return lst


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        rnres, stack = [], []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack: 
            	return res
            node = stack.pop()
            res.append(node.val)
            root = node.right