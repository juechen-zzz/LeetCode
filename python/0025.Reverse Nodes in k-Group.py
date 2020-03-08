'''
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
	def reverseKGroup(self, head, k):
		"""
		:type head: ListNode
		:type k: int
		:rtype: ListNode
		"""
		if not head: return None
		speed = 0
		slow = fast = head
		while speed < k - 1 and fast:
			fast = fast.next
			speed += 1
		if fast is None: return slow
		second = fast.next
		fast.next = None
		first = slow
		h,t =self.reversL(first)
		t.next = self.reverseKGroup(second, k)
		return h

	def reversL(self, head):
		dummyNode = ListNode(-1)
		tail = head
		while head:
			tmp = head.next
			head.next = dummyNode.next
			dummyNode.next = head
			head = tmp
		return dummyNode.next,tail
        