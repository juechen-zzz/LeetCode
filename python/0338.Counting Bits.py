"""
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
"""

class Solution:
    def countBits(self, num: int) -> List[int]:
        bins = []
        for i in range(num + 1):
            c = collections.Counter(bin(i))
            if '1' not in c:
                bins.append(0)
            else:
                bins.append(c['1'])
        return bins