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


class Solution(object):  
    def swapPairs(self, head):  
        """ 
        :type head: ListNode 
        :rtype: ListNode 
        """  
        if head == None:
            return head
        cur = ListNode(0)
        cur.next = head
        first =cur
        while cur.next and cur.next.next:
            n1 = cur.next
            n2 = n1.next
            nxt = n2.next
            n1.next = nxt
            n2.next = n1
            cur.next = n2
            
            cur = n1
        return first.next

