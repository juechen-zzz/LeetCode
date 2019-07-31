"""
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
"""


class Solution:
    def countPrimes(self, n: int) -> int:
        count, sieve = 0, [True] * n
        for i in range(2, n):
            if sieve[i]:
                count += 1
                for j in range(i * i, n, i):
                    sieve[j] = False
        return count
