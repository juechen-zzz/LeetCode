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
        if not head: return None
        curr1 = ListNode(-1)
        curr2 = ListNode(-1)
        c1 = curr1
        c2 = curr2
        while head:
            if head.val < x:
                c1.next = head
                c1 = c1.next
            else:
                c2.next = head
                c2 = c2.next
            head = head.next
        c2.next = None              # 结尾很重要，不然会超时
        c1.next = curr2.next
        return curr1.next
        