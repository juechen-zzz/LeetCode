'''
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
'''

def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
    wordDict = dict()
    for w in [beginWord] + wordList:
        wordDict[w] = True
        
    if endWord not in wordDict:
        return []
    
    adjacentDict = dict()
    def adjacentWords(w):
        if w in adjacentDict:
            return adjacentDict[w]
        
        adjacent = []
        for i in range(0, len(w)):
            for ch in range(0, 26):
                t = w[0:i] + chr(ch+97) + w[i+1:]
                if t in wordDict:
                    adjacent.append(t)
        adjacentDict[w] = adjacent
        return adjacent
    
    def bfs(start, end):
        q = [start]
        visited = dict()
        visited[start] = 0
        while len(q) > 0:
            p = q[0]
            q = q[1:]
            level = visited[p]
            adjacent = adjacentWords(p)
            if end in adjacent:
                return level + 1
            for v in adjacent:
                if v not in visited:
                    visited[v] = level + 1
                    q.append(v)
        if end not in visited:
            return -1
    
    level = bfs(beginWord, endWord)

    if level < 0:
        return []
    
    result = []
    cache = dict()
    def dynamic_search(start, end, max_level):
        if max_level < 1:
            return []
        
        adjacent = adjacentWords(end)
        if start in adjacent:
            return [[start, end]]
        
        if max_level == 1:
            return []
        search_result = []
        for word in adjacent:
            key = word + ':' + str(max_level-1)
            last = None
            if key in cache:
                last = cache[key]
            else:
                last = dynamic_search(start, word, max_level - 1)
            for sr in last:
                if len(sr) > 0 and len(sr) <= max_level:
                    search_result.append(sr + [end])
                
        cache[end+':'+str(max_level)] = search_result
        return search_result
            
    result = dynamic_search(beginWord, endWord, level)
    return result