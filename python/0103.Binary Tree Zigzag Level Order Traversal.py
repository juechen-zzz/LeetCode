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
        result = []
        if root is None:
            return result
        queue = collections.deque()
        queue.append(root)
        left_to_right = True
        while queue:
            level_size = len(queue)
            cur_level = collections.deque()
            for _ in range(level_size):
                cur_node = queue.popleft()
                cur_level.append(cur_node.val) if left_to_right else cur_level.appendleft(cur_node.val)
                if cur_node.left:
                    queue.append(cur_node.left)
                if cur_node.right:
                    queue.append(cur_node.right)
            result.append(list(cur_level))
            left_to_right = not left_to_right
        return result