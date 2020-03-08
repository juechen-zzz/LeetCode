'''
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
'''

def maxProduct(self, nums):
	if len(nums) == 0:
		return 0

	ans = nums[0]
	negtive, positive = 0, 0
	for x in nums:
		if x < 0:
			negtive, positive = positive * x, negtive * x
			if negtive == 0:
				negtive = x
		elif x > 0:
			negtive, positive = negtive * x, positive * x
			if positive == 0:
				positive = x
		else:
			ans = max(ans, 0)
			negtive, positive = 0, 0 
		if negtive < 0:
			ans = max(ans, negtive)
		if positive > 0:
			ans = max(ans, positive)
	return ans 