"""
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next: return head
        slow, fast = head, head.next
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
        mid, slow.next = slow.next, None

        left, right = self.sortList(head), self.sortList(mid)

        res = p = ListNode(-1)
        while left and right:
            if left.val < right.val: p.next, left = left, left.next
            else: p.next, right = right, right.next
            p = p.next
        p.next = left if left else right
        return res.next
