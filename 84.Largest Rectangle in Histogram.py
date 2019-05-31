'''
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
'''

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []

        max_rectangle = 0

        inputs_len = len(heights)

        for i in range(inputs_len):
            if not stack and heights[i]:
                stack.append((heights[i], i))
            else:
                start_i = i
                while stack:
                    if heights[i] >= stack[-1][0]:
                        # append when heights[i] > stack top value
                        if stack[-1][0] != heights[i]:
                            stack.append((heights[i], start_i))

                        break
                    else:
                        h, start_i = stack.pop()
                        max_rectangle = max(h * (i - start_i), max_rectangle)
                else:
                    # loop escape because empty stack
                    if heights[i]:
                        stack.append((heights[i], start_i))

        while stack:
            h, start_i = stack.pop()
            max_rectangle = max(h * (inputs_len - start_i), max_rectangle)

        return max_rectangle