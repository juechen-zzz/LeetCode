'''
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
'''
# 总面积然后减去所有柱子的面积的方法。这种方法我感觉算不上是双指针，但也是把图从最高点分成两块从两头计算。
class Solution:
    def trap(self, height: List[int]) -> int:
        m,minx = 0, 0
        sumh = 0
        for idx,num in enumerate(height):
            sumh += height[idx]
            if num > m:
                m = num
                minx = idx
        cnt = 0
        maxi, maxj = 0, 0
        for i in range(minx):                               # 左边总面积
            maxi = max(maxi,height[i])
            cnt += maxi
        for j in reversed(range(minx,len(height))):         # 右边总面积
            maxj = max(maxj,height[j])
            cnt += maxj
        return cnt-sumh

# 只需要一次循环，用左右两个指针，左指针记录左边遇到的最大值，右指针记录右边遇到的最大值
# 每轮循环将两个最大值加起来，并且减去当前柱子的高度。
# 最后减去总体面积即可
class Solution:
    def trap(self, height: List[int]) -> int:
        ans, lmax, rmax = 0, 0, 0
        for i in range(len(height)):
            lmax = max(lmax, height[i])
            rmax = max(rmax, height[-1-i])
            ans += lmax + rmax - height[i]
        return ans-lmax*len(height)
        
