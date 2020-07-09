'''
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None: return head
        val = []
        cur = head
        while cur is not None:
            val.append(cur.val)
            cur = cur.next
        k = k % len(val)
        r_val = val[-k:] + val[:-k]
        cur = head
        for val in r_val:
            cur.val = val
            cur = cur.next
        
        return head

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None: return head
        cur = head
        num = 0
        while cur:
            cur = cur.next
            num += 1
        first = second = head
        k = k % num
        for i in range(k,0,-1):
            first = first.next
        while first.next:
            first = first.next
            second = second.next
        first.next = head 
        head = second.next
        second.next = None
        return head

        