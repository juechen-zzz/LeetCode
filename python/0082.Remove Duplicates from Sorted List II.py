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
        if not head: return None
        # defaultdict还可以被用来计数，将default_factory设为int即可
        # 字符串中的字母第一次出现时，字典中没有该字母，default_factory函数调用int()为其提供一个默认值0,加法操作将计算出每个字母出现的次数
        freq = collections.defaultdict(int)
        nums = []
        curr = head
        
        while curr:
            freq[curr.val] += 1
            nums.append(curr.val)
            curr = curr.next
        
        rhead = ListNode(-1)
        curr = rhead
        while nums:
            n = nums.pop(0)
            if freq[n] == 1:
                curr.next = ListNode(n)
                curr = curr.next
        return rhead.next