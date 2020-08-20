"""
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) < 1: return 0
        citations.sort()
        cite = 1
        h = 0
        for i in range(len(citations)-1, -1, -1):
            if citations[i] >= cite:
                cite += 1
                h += 1
            else:
                return h
        return h
