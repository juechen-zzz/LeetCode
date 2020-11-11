"""
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
"""

class Solution:
    def dist(self, p,q):
        return (p[0]-q[0])**2 + (p[1]-q[1])**2

    def validSquare(self, p1, p2, p3, p4):
        s = set([self.dist(p1, p2), self.dist(p1, p3), self.dist(p1, p4), self.dist(p2, p3), self.dist(p2, p4), self.dist(p3, p4)])
        return 0 not in s and len(s) == 2
        