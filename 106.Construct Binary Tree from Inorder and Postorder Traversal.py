"""
iven inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder:
            return None
        head = TreeNode(postorder[-1])
        stack = [head]
        i = len(postorder)-2
        j = i+1
        
        while i >= 0:
            tmp = None
            t = TreeNode(postorder[i])
            while stack and stack[-1].val == inorder[j]:
                tmp = stack.pop()
                j-=1
            if tmp:
                tmp.left = t
            else:
                stack[-1].right = t
            i-=1
            stack.append(t)
        return head