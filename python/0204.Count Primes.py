"""
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
"""

# 要得到自然数n以内的全部质数，必须把不大于根号n的所有质数的倍数剔除，剩下的就是质数。
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 2: return 0
        isPrime = [1] * n
        isPrime[0] = isPrime[1] = 0   # 0和1不是质数，先排除掉
        # 埃式筛，把不大于根号n的所有质数的倍数剔除
        for i in range(2, int(n ** 0.5) + 1):
            if isPrime[i]:
                isPrime[i * i:n:i] = [0] * ((n - 1 - i * i) // i + 1)
        return sum(isPrime)
