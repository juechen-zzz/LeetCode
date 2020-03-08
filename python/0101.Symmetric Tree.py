'''
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        left, right = [], []
        self.leftFirst(root, left, root)
        self.rightFirst(root, right, root)
         
        return left == right
        
        
    def leftFirst(self, node: TreeNode, left: list, root: TreeNode):
        if not node:
            left.append("null")
        else:
            self.leftFirst(node.left, left, root)
            self.leftFirst(node.right, left, root)
            left.append(node.val)
            if node == root:
                return
        
    def rightFirst(self, node: TreeNode, right: list, root: TreeNode):
        if not node:
            right.append("null")
        else:
            self.rightFirst(node.right, right, root)
            self.rightFirst(node.left, right, root)
            right.append(node.val)
            if node == root:
                return