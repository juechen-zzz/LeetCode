'''
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        def helper(root):
            if not root:
                return 0
            else:
                l = helper(root.left)
                r = helper(root.right)
                if min(l,r) != 0:
                    return 1 + min(l,r)
                else:
                    return 1 + max(l,r) 
        return helper(root) 