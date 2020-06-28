'''
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head == None: return head
        cur = ListNode(-1)
        cur.next = head
        p = cur
        while p.next and p.next.next:
            n1 = p.next
            n2 = n1.next
            temp = n2.next
            p.next = n2
            n2.next = n1
            n1.next = temp

            p = n1
        return cur.next
