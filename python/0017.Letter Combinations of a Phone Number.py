'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
'''

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dt = {'1':'', '2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz', '0':''}
        if len(digits) == 0: return []
        elif len(digits) == 1: 
            return [s for s in dt[digits[0]]]
        elif len(digits) == 2:
            return [a+b for a in dt[digits[0]] for b in dt[digits[1]]]
        else:
            str_list = self.letterCombinations(digits[1:])
            return [a+b for a in dt[digits[0]] for b in str_list]