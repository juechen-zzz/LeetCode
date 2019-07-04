'''
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
'''

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        visited=set()

        wordDic={}

        for word in wordList:
            for w in range(len(word)):
                if w==len(word)-1:
                    temp=word[:w]+'*'
                else:
                    temp=word[:w]+'*'+word[w+1:]

                if temp not in wordDic:
                    wordDic[temp]=set([word])
                else:
                    wordDic[temp].add(word)

        visiting=[beginWord]
        step_count=1
        stop=0

        while visiting:
            step_count+=1
            visiting_next=[]
            for v in visiting:
                #print(v)
                for i in range(len(v)):
                    if i==len(v)-1:
                        temp=v[:i]+'*'
                    else:
                        temp=v[:i]+'*'+v[i+1:]
                    if temp in wordDic:
                        for word in wordDic[temp]:
                            if word not in visited:
                                if word==endWord:
                                    return step_count

                                visiting_next.append(word)
                                visited.add(word)

            visiting=visiting_next
            if stop: break
        return 0