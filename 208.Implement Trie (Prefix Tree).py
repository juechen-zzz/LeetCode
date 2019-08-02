"""
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

"""


class Trie(object):
    trie = [0, {}]

    def __init__(self):
        self.trie = [0, {}]

    def insert(self, word):
        p = self.trie
        for x in word:
            if x not in p[1]:
                p[1][x] = [0, {}]
            p = p[1][x]
        p[0] += 1

    def search(self, word):
        p = self.trie
        cnt = 0
        for x in word:
            if x in p[1]:
                p = p[1][x]
                cnt += 1
        return cnt == len(word) and p[0] > 0

    def startsWith(self, prefix):
        p = self.trie
        cnt = 0
        for x in prefix:
            if x in p[1]:
                p = p[1][x]
                cnt += 1
        return cnt == len(prefix)