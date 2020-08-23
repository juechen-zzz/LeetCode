"""
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

1.找出所有的Bulls
2.将两个字符串计数转化为字典
3.比较相同字符数，并将较小的累加得到所有的Cows
4.按照题目意思Cows不包括Bulls，最后减去Bulls
5.拼接字符串返回结果
"""

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        Bulls = Cows = 0
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                Bulls += 1
        d1 = dict(collections.Counter(list(secret)))
        d2 = dict(collections.Counter(list(guess)))
        for i in d1:
            if i in d2:
                Cows += min(d1[i],d2[i])
        Cows = Cows - Bulls
        return str(Bulls)+"A"+str(Cows)+"B"
