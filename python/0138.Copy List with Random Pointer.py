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
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head is None:
            return None
        
		# Create node copy next to the original node ( weaving in the solution 3) #
        ptr = head
        while ptr:
            node = Node(ptr.val, None, None)
            node.next = ptr.next
            ptr.next = node
            ptr = node.next
        
		# Random pointers are easy to add in the weaved linked list #
        ptr = head
        while ptr:
            ptr.next.random = ptr.random.next if ptr.random else None
            ptr = ptr.next.next
        
		# un-weaving the two linked list, neater than code in the solution 3 #
        old, new = head, head.next
        newhead = head.next
        while old:
            old.next = new.next
            old = old.next
            if old:
                new.next = old.next
                new = new.next
            
        return newhead