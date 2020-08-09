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
        if not head: return None
        cur = head
        pre = None
        while cur is not None:
            if cur.val == val:
                if pre:
                    pre.next = cur.next
                else:
                    head = head.next
            else:
                pre = cur
            cur = cur.next
        return head