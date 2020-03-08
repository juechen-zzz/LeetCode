"""
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
"""


class Solution:
    # Trie
    # complex number -> Coordinate i + 1j * j
    # Time O mn* max(len(word))
    # Space O len(words)

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m, n = len(board), len(board[0])
        ans = []

        # Trie
        root = {}
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, {})
            node[None] = True

        # print(root)
        # board = {i + 1j*j: c
        #          for i, row in enumerate(board)
        #          for j, c in enumerate(row)}
        # print(board)
        def dfs(i, j, word, node):
            # print(i,j,word,node)
            if node.pop(None, None):
                ans.append(word)
                # print('!!!!!!!!!')
                # return
            if i < 0 or j < 0 or i == m or j == n:
                # print('out')
                return
            if board[i][j] not in node:
                # print('not')
                return

            tmp = board[i][j]
            board[i][j] = '0'
            dfs(i - 1, j, word + tmp, node[tmp])
            dfs(i + 1, j, word + tmp, node[tmp])
            dfs(i, j - 1, word + tmp, node[tmp])
            dfs(i, j + 1, word + tmp, node[tmp])
            board[i][j] = tmp

        for i in range(m):
            for j in range(n):
                dfs(i, j, '', root)

        return ans
