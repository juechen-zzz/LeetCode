"""
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
"""


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        current = head
        prev = None
        while current is not None:
            if current.val == val:
                if prev:
                    prev.next = current.next
                else:
                    head = head.next
            else:
                prev = current
                current = current.next
        return head