'''
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
'''

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head: return None
        p = head
        stack = []
        while p:
            stack.append(p)
            p = p.next

        n = len(stack)
        # 找到中点前一个位置 
        count = (n - 1) // 2
        p = head
        while count:
            # 弹出栈顶
            tmp = stack.pop()
            # 与链头拼接
            tmp.next = p.next
            p.next  = tmp
            # 移动一个位置
            p = tmp.next
            count -= 1
        stack.pop().next = None
