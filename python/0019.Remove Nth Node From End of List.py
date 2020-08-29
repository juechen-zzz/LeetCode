'''
删除倒数第n个节点，返回头节点

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if head.next == None: return 
        
        cur = head
        pre = head
        for i in range(n):
            pre = pre.next
        if pre == None: return head.next
        while pre.next:
            pre = pre.next
            cur = cur.next
        cur.next = cur.next.next
        return head
        