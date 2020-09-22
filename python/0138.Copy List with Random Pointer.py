'''
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 

Example 1:



Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return None

        # 第一遍遍历，把每个新生成的结点放在对应的旧结点后面
        p = head
        while p:
            newNode = Node(p.val)
            newNode.next = p.next
            p.next = newNode

            p = newNode.next       # 下一个旧结点
        
        # 第二遍修改每个新结点的 next 和 random 
        p = head
        while p:
            nextOrigin = p.next.next        # 下一个旧结点备份一下
            p.next.next = nextOrigin.next if nextOrigin else None   # 修改新结点的 next
            p.next.random = p.random.next if p.random else None    # 修改新结点的 random

            p = nextOrigin         # 下一个旧结点
        
        return head.next
