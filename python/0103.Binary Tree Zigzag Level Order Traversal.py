'''
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        queue = []
        ans = []
        if not root: return ans
        queue.append(root)
        left_to_right = True
        while queue:
            sub_ans = []
            l = len(queue)
            for i in range(l):
                node = queue.pop(0)
                sub_ans.append(node.val)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            if left_to_right:
                ans.append(sub_ans)
            else:
                ans.append(sub_ans[::-1])
            left_to_right = not left_to_right
        return ans