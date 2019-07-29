"""
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # find the right most node on each level
        # do a bread first search and find the one last element on each level
        stack = []
        out = []
        if not root:
            return out
        stack.append(root)
        out.append(root.val)
        while(stack):
            next_level = []
            for ele in stack:
                if ele.left:
                    next_level.append(ele.left)
                if ele.right:
                    next_level.append(ele.right)
            if next_level:
                out.append(next_level[-1].val)
            stack = next_level
        return out