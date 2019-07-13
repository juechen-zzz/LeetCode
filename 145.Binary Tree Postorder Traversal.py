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
        def dfs(node):
            if not node:
                return
            dfs(node.left)
            dfs(node.right)
            post_order.append(node.val)
        
        post_order = []
        dfs(root)
        return post_order


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        post_order = []
        stack = [root]
        visited = {root}
        while stack:
            top = stack[-1]
            no_next = True
            if top.right and top.right not in visited:
                stack.append(top.right)
                visited.add(top.right)
                no_next = False
            if top.left and top.left not in visited:
                stack.append(top.left)
                visited.add(top.left)
                no_next = False
            if no_next:
                post_order.append(top.val)
				stack.pop()
        return post_order


