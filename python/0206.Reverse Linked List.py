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
    def reverseList(self, head):
        if head == None:
            return None

        l = []
        current = head
        l.append(head)

        while current.next != None:
            current = current.next
            l.append(current)

        for i in range(len(l)-1, -1, -1):
            if i == 0:
                l[i].next = None
                break
            l[i].next = l[i-1]

        return l[-1]