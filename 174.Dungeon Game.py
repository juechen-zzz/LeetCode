"""
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)


Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
"""

from typing import List

class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        m, n = len(dungeon), len(dungeon[0])
        dp = [0 for _ in range(n)]
        for i, n in enumerate(dungeon[-1][::-1], 1):
            dp[-i] = n + (min(0, dp[-i+1]) if i != 1 else 0)
        for rows in dungeon[:-1][::-1]:
            for i, col in enumerate(rows[::-1], 1):
                if i != 1:
                    dp[-i] = max(min(0, dp[-i + 1]), min(0, dp[-i])) + col

                else:
                    dp[-i] = min(0, dp[-i]) + col

        ans = 1 if dp[0] >= 0 else abs(dp[0]) + 1
        return ans


class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        m=len(dungeon)
        n=len(dungeon[0])
        dp=[[0 for index in range(n)] for index in range(m)]
        dp[m-1][n-1]=max(1,1-dungeon[m-1][n-1])
        for row in reversed(range(m-1)):
            dp[row][n-1]=max(1,dp[row+1][n-1]-dungeon[row][n-1])
        for col in reversed(range(n-1)):
            dp[m-1][col]=max(1,dp[m-1][col+1]-dungeon[m-1][col])
        for row in reversed(range(m-1)):
            for col in reversed(range(n-1)):
                dp[row][col]=max(1,min(dp[row+1][col],dp[row][col+1])-dungeon[row][col])
        return dp[0][0]


