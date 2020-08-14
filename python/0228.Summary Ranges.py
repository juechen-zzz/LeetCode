"""
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

"""

class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n = len(nums)
        if(n == 1): return [str(nums[0])]
        res = []
        l, r, cur = 0, 0, 0
        while cur < n:
            while cur < n and nums[cur] - nums[r] <= 1:
                r = cur
                cur += 1
            if(l == r):
                res.append(str(nums[l]))
            else:
                res.append(str(nums[l])+"->"+str(nums[r]))
            l, r = cur, cur
        return res
