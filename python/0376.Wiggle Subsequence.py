"""
    摆动序列:
    如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
    第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列

    给定一个整数序列，返回作为摆动序列的最长子序列的长度。 
    通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
"""

class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) < 2: return len(nums)
        stack = []
        prev = 0
        for n in nums:
            if len(stack) == 0: 
                stack.append(n)
            else:
                if stack[-1] == n:
                    stack.pop()
                else:
                    curr = 1 if n - stack[-1] > 0 else -1
                    if prev == curr: stack.pop()
                    prev = curr
                stack.append(n)
        return len(stack)
