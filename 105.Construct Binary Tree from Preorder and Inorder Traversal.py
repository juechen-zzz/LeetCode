'''
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        """
        Time Complexity: O(N)
            Where N is the length of preorder and inorder
        Space Complexity: O(N)
            Where N is the length of preorder and inorder
        """
        def build(l, r):
            if l <= r:
                node = TreeNode(preorder[build.pre_idx])
                build.pre_idx += 1
                node.left = build(l, inorder_idxs[node.val] - 1)
                node.right = build(inorder_idxs[node.val] + 1, r)
                return node
        
        build.pre_idx = 0
        inorder_idxs = {n: i for i, n in enumerate(inorder)}
        return build(0, len(inorder) - 1)