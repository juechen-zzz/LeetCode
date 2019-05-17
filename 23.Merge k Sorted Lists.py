'''
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        num_list = []
        if lists == []:
            return []
        else:
            for i in lists:
                while i:
                    num_list.append(i.val)
                    i = i.next

        num_list.sort()
        head = ListNode(0)
        first = head
        for i in num_list:
            head.next = ListNode(i)
            head = head.next

        return first.next
