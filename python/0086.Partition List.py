'''
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head:
            return None
        bef = []
        aft = []
        node = head
        while node != None:
            if node.val < x:
                bef += node.val,
            else:
                aft += node.val,
            node = node.next

        rhead = None
        if bef:
            rhead = ListNode(bef.pop(0))
        else:
            rhead = ListNode(aft.pop(0))
            
        node = rhead
        while bef:
            node.next = ListNode(bef.pop(0))
            node = node.next
        while aft:
            node.next = ListNode(aft.pop(0))
            node = node.next
        return rhead
