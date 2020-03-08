'''
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
  '''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        prev = None
        for node in self.serialize(root):
            if prev and prev.val > node.val:
                first = prev
                break
            prev = node
        prev = None
        for node in self.serialize(root, out=True):
            if prev and prev.val < node.val:
                last = prev
                break
            prev = node
        first.val, last.val = last.val, first.val

    def serialize(self, root, out=False):
        """Iterate through nodes in-order or out-order"""
        if not root:
            return
        if out:
            r, l = root.left, root.right
        else:
            l, r = root.left, root.right
        for node in self.serialize(l, out):
            yield node
        yield root
        for node in self.serialize(r, out):
            yield node
                