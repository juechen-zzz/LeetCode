'''
原地删除数组中指定元素，返回长度
Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
'''

class Solution:
	def removeElement(self, nums: List[int], val: int) -> int:
		i,last=0,len(nums)-1
		while i<=last:
			if nums[i]==val:
				nums[i],nums[last]=nums[last],nums[i]
				last-=1
			else:
				i+=1
		return last+1