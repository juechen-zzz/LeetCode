"""
一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
        

class Solution:
    def rob(self, root):
        def dfs(node):
            if not node: return [0, 0]
            L = dfs(node.left)
            R = dfs(node.right)
            # 偷当前节点, 则左右子树都不能偷；不偷当前节点, 则取左右子树中最大的值
            return [node.val + L[1] + R[1], max(L) + max(R)]
        return max(dfs(root))