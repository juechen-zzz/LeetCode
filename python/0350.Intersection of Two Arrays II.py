"""
    给定两个数组，找出其中重叠的数字(重复出现的全算)

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
"""

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) == 0 or len(nums2) == 0: return []
        ans = []
        for n in nums1:
            if n in nums2:
                ans.append(n)
                nums2.remove(n)
        return ans