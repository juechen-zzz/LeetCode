"""
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None: return None
        stack = []
        while head:
            stack.append(head)
            head = head.next
        cur = ListNode(-1)
        temp = cur
        while stack:
            node = stack.pop()
            temp.next = node
            temp = temp.next
        temp.next = None
        return cur.next
