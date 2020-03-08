"""
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

"""
import collections


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        adj_map = {}  # maintains adjacency list
        n = numCourses
        in_deg = [0] * n

        for edge in prerequisites:
            in_deg[edge[0]] += 1
            if edge[1] in adj_map:
                adj_map[edge[1]].append(edge[0])
            else:
                adj_map[edge[1]] = []
                adj_map[edge[1]].append(edge[0])

        count = 0

        Q = collections.deque()

        for node in range(n):
            if in_deg[node] == 0:
                Q.append(node)

        while Q:
            node = Q.popleft()
            count += 1
            if node in adj_map:
                for child in adj_map[node]:

                    in_deg[child] -= 1

                    if in_deg[child] == 0:
                        Q.append(child)

        return count == n
