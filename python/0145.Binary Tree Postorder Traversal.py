"""
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        
        def helper(root):
            if root == None:
                return   # 叶节点没有子树，递归终止
            helper(root.left)   # 遍历左
            helper(root.right)  # 遍历右
            res.append(root.val)  # 根
            
        helper(root)
        return res
