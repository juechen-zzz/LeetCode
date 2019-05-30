'''
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
            if not head:
                return None
            freq = collections.defaultdict(int)
            t = []
            node = head
            while node != None:
                freq[node.val] += 1
                t += node.val,
                node = node.next
            rhead = None
            while t:
                cur = t.pop(0)
                if freq[cur] == 1:
                    rhead = ListNode(cur)
                    break
            node = rhead
            while t:
                cur = t.pop(0)
                if freq[cur] == 1:
                    node.next = ListNode(cur)
                    node = node.next
            return rhead