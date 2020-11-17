"""
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.

"""

class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        if n <= 0 or not primes: return 0
        if n == 1: return 1
        numbers = [1]
        k = len(primes)
        index = [0] * k
        m = [0] * k
        for x in range(n-1):
            for y in range(k):
                # 取index[y]是可以从numbers中拿出在走了index[y]步后的最小值再进行下一步乘法
                m[y] = numbers[index[y]] * primes[y]
            ans = min(m)
            numbers.append(ans)
            for y in range(k):
                index[y] += (m[y] == ans)
        return ans
