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

# 栈
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack: 
            	return res
            node = stack.pop()
            res.append(node.val)
            root = node.right

# 回溯
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        
        def helper(root):
            if root == None:
                return   # 叶节点没有子树，递归终止
            helper(root.left)   # 遍历左
            res.append(root.val)  # 根
            helper(root.right)  # 遍历右
            
        helper(root)
        return res

