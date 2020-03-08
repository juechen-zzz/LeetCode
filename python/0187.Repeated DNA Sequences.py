"""
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
"""

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        res, dic = [], {}
        for i in range(0, len(s)-9):
            substring = s[i:i+10]
            if substring in dic and dic[substring] == False:
                res.append(substring)
                dic[substring] = True
            elif substring not in dic:
                dic[substring] = False
        return res