"""
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
"""

# solution 1
def isHappy(n):
    ans = []
    while n // 10 > 0:
        ans.append(n % 10)
        n = n // 10
    ans.append(n)
    print(ans)
    s = 0
    for i in range(len(ans)):
        s += ans[i] ** 2
    print(s)
    if s == 1:
        return True
    else:
        isHappy(s)


# solution 2
def isHappy(n):
    dictionary = {}
    for i in range(10):
        dictionary[i] = i * i
    visited = {n: True}
    while True:
        new_n = 0
        while n != 0:
            new_n += dictionary[n % 10]
            n //= 10
        if new_n == 1:
            return True
        if new_n in visited:
            return False
        visited[new_n] = True
        n = new_n
    return True

isHappy(19)
