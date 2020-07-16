'''
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        stack = []
        l = n - m + 1

        origin = prev = ListNode(-1)
        prev.next = head
        while head:
            m -= 1
            if m == 0:
                while l > 0:
                    stack.append(head)
                    head = head.next
                    l -= 1
                while stack:
                    prev.next = stack.pop()
                    prev = prev.next
                prev.next = head
                break
            prev = head
            head = head.next
        return origin.next
