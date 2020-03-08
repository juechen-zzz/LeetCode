'''
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

'''

# python3
from functools import reduce
from math import ceil

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        s = ''
        l = list(range(1, n + 1))
        while n != 1:
            f = reduce(lambda x, y: x * y, range(1, n))
            t = ceil(k / f)
            s += str(l.pop(t - 1))
            k -= (t - 1) * f
            n -= 1
        return s + str(l[0])

# python2
class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = map(str, range(1, 10))
        k -= 1
        factor = 1
        for i in range(1, n):
            factor *= i
        res = []
        for i in reversed(range(n)):
            res.append(nums[k / factor])
            nums.remove(nums[k / factor])
            if i != 0:
                k %= factor
                factor /= i
        return "".join(res)