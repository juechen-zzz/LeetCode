'''
给定两个数组，查找中位数r

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        ans = nums1 + nums2
        # 数组可以直接加连，然后排序
        ans.sort()
        n = len(ans) // 2
        if len(ans) % 2 == 1:
            return ans[n]
        else:
            return (ans[n] + ans[n-1]) / 2
