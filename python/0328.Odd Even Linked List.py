"""
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        odd = cur = ListNode(-1)
        even = pre = ListNode(-1)
        count = 0
        while head:
            if count % 2 == 0:
                cur.next = head
                cur = cur.next
            else:
                pre.next = head
                pre = pre.next
            head = head.next
            count += 1
        cur.next = even.next
        pre.next = None
        return odd.next