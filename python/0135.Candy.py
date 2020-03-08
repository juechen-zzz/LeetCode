"""
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             '''
"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        length = len(ratings)
        res = [1] * length

        i = 1
        peak = 0
        peakVal = 1
        ans = 1 
        pre = 1
        while i < length:
        	if ratings[i] > ratings[i-1]:
        		peak = i
        		peakVal = pre + 1
        		pre = pre + 1
        		ans = ans + pre
        	elif ratings[i] < ratings[i-1]:
        		ans = ans + 1
        		if pre <= 1:
        			if i - peak < peakVal:
        				ans = ans + i - peak -1
        			else:
        				peakVal = i - peak + 1
        				ans = ans + i - peak
        		pre = 1
        	else:
        		ans = ans + 1
        		peak = i 
        		peakVal = 1
        		pre = 1
        	i += 1
        return ans