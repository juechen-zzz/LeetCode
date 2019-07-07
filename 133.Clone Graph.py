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
class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
# python2

class Solution(object):
    def __init__(self):
        self.map = {}
        
    def _cloneGraph(self, node):
        if node in self.map: return
        clone_node = Node(node.val, [])
        self.map[node] = clone_node
        for adj in node.neighbors:
            if adj not in self.map:
                self._cloneGraph(adj)
        for adj in node.neighbors:
            self.map[node].neighbors.append(self.map[adj])
        
    def cloneGraph(self, node):
        self._cloneGraph(node)
        return self.map[node]