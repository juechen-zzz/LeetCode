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
        # * merge sort
        def helper(head, dummy):
            if head.next is None:
                return head
            
            fast = head
            slow = head
            
            while fast and fast.next:
                prev = slow
                slow = slow.next
                fast = fast.next.next

            # slow now is at the center of the list
            # break the list into two sublists
            prev.next = None

            # merge-sort the two sublists
            list0 = helper(head, dummy)
            list1 = helper(slow, dummy)

            # merge the two sublists
            node = dummy
            while list0 is not None or list1 is not None:
                if list0 is not None and list1 is not None:
                    if list0.val < list1.val:
                        node.next = list0
                        list0 = list0.next
                    else:
                        node.next = list1
                        list1 = list1.next
                    node = node.next
                elif list0 is None:
                    node.next = list1
                    break
                elif list1 is None:
                    node.next = list0
                    break            

            return dummy.next

        if head is None:
            return head
        
        return helper(head, ListNode(-1))