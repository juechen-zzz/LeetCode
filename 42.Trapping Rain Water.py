'''
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)<3:
            return 0
        l,r = [], []
        hi,i = 0, 0
        while i<len(height):
            l+=hi,
            hi=max(hi,height[i])
            i+=1
        i,hi=i-1,0
        while i>-1:
            r+=hi,
            hi=max(hi,height[i])
            i-=1
        ans=0
        i+=1
        while i<len(height):
            ans+=max(0,min(l[i],r[~i])-height[i])
            i+=1
        return ans