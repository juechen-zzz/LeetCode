"""
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

如果存在则返回 true，不存在返回 false。

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
"""

# 首先，定义桶的大小是t+1, nums[i]//(t+1)决定放入几号桶,这样在一个桶里面的任意两个的绝对值差值都<=t
# 例如t=3, nums=[0 ,5, 1, 9, 3,4],那么0号桶就有[0,1,3],1号桶就有[4,5],2号桶就有[9]

# 先不考虑索引差值最大为K的限制，那么遍历nums每一个元素，并把他们放入相应的桶中，有两种情况会返回True

# 1 要放入的桶中已经有其他元素了，这时将nums[i]放进去满足差值<=t
# 2 可能存在前面一个桶的元素并且与nums[i]的差值<=t 或者 存在后面一个桶的元素并且与nums[i]的差值<=t
# 根据返回True的第一个条件，可以知道前后桶的元素最多也只能有一个。

# 接着考虑限制桶中的索引差最大为K,当i>=k的时候：
# 我们就要去删除存放着nums[i-k]的那个桶(编号为nums[i-k]//(t+1))
# 这样就能保证遍历到第i+1个元素时，全部桶中元素的索引最小值是i-k+1，就满足题目对索引的限制了


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        bucket = {}
        if t < 0: return False
        for i in range(len(nums)):
            nth = nums[i] // (t + 1)
            if nth in bucket:
                return True
            if nth - 1 in bucket and abs(nums[i] - bucket[nth - 1]) <= t:
                return True
            if nth + 1 in bucket and abs(nums[i] - bucket[nth + 1]) <= t:
                return True
            bucket[nth] = nums[i]
            if i >= k: bucket.pop(nums[i - k] // (t + 1))
        return False
