'''
给定两数（链表反序表示），相加后也反向存储成链表

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Definition for singly-linked list.
 class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        head = ListNode(0)
        curr = head
        while (l1 or l2):
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2.next
            curr.next = ListNode(carry % 10)
            curr = curr.next
            carry = carry // 10
        if carry == 1:
            curr.next = ListNode(1)
            curr = curr.next
        return head.next