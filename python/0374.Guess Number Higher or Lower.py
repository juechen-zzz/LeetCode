"""
    猜数的高低
"""

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        mini, maxi = 1, n
        while True:
            if guess(n) == 0: return n
            elif guess(n) == 1:
                mini = n
            else:
                maxi = n
            n = int((mini + maxi) / 2)
