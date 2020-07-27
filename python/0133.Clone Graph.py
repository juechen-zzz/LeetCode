'''
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 

Example:



Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
# DFS
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        lookup = {}

        def dfs(node):
            if not node: return
            if node in lookup: return lookup[node]      # 判断是否遍历过
            clone = Node(node.val, [])
            lookup[node] = clone
            for n in node.neighbors:
                clone.neighbors.append(dfs(n))
            return clone

        return dfs(node)

# BFS
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        from collections import deque
        lookup = {}

        def bfs(node):
            if not node: return
            clone = Node(node.val, [])
            lookup[node] = clone
            queue = deque()
            queue.appendleft(node)
            while queue:
                tmp = queue.pop()
                for n in tmp.neighbors:
                    if n not in lookup:
                        lookup[n] = Node(n.val, [])
                        queue.appendleft(n)
                    lookup[tmp].neighbors.append(lookup[n])
            return clone

        return bfs(node)