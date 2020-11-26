"""
    给定一个数组，找出其中出现次数最多的前K个数

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
"""

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]: 
        if k == len(nums): return nums
        count = collections.Counter(nums)  
        # nlargest和nsmallest()可以帮助我们在某个集合中找出最大或最小的N个元素
        return heapq.nlargest(k, count.keys(), key=count.get) 