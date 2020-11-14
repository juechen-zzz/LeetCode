"""
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
"""
class Solution:
    def valid(self, n):
        return True if n == '0' or n[0] != '0' else False
        
    def isAdditiveNumber(self, num: str) -> bool:
        q = deque((0, i, j) for i in range(1, len(num)-1) for j in range(i+1, len(num)))
        # deque([(0, 1, 2), (0, 1, 3), (0, 1, 4), (0, 1, 5), (0, 2, 3), (0, 2, 4), (0, 2, 5), (0, 3, 4), (0, 3, 5), (0, 4, 5)])
        
        while q:
            x = q.popleft()
            if self.valid(num[x[0]: x[1]]) and self.valid(num[x[1]: x[2]]):
                dig = str(int(num[x[0]: x[1]]) + int(num[x[1]: x[2]]))
                if len(dig) + x[2] == len(num) and num[x[2]: x[2] + len(dig)] == dig:
                    return True
                if len(dig) + x[2] < len(num) and num[x[2]: x[2] + len(dig)] == dig:
                    q.append((x[1], x[2], x[2] + len(dig)))
        return False
