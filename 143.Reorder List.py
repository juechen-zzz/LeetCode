'''
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head and head.next and head.next.next:
            node = head
            linklist = []
            while(node):
                linklist.append(node)
                node = node.next
            revlinklist = list(reversed(linklist))
            if len(linklist) % 2 == 0:
                for i in range(len(linklist)/2):
                    linklist[i].next = revlinklist[i]
                    revlinklist[i].next = linklist[i+1]
                    if i == len(linklist)/2-1:
                         revlinklist[i].next = None
            else:
                for i in range(len(linklist) / 2 + 1):
                    linklist[i].next = revlinklist[i]
                    revlinklist[i].next = linklist[i+1]
                    if i == len(linklist)/2:
                         revlinklist[i].next = None
