"""
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
"""

class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        # 调整两个矩形位置, 让第一个矩形靠最左边
        if A > E:
            return self.computeArea(E, F, G, H, A, B, C, D)
        # 没有重叠的情况
        if B >= H or D <= F or C <= E:
            return abs(A - C) * abs(B - D) + abs(E - G) * abs(F - H)
        # 重叠情况
        # 下边界
        down = max(A, E)
        # 上
        up = min(C, G)
        # 左
        left = max(B, F)
        # 右
        right = min(D, H)
        return abs(A - C) * abs(B - D) + abs(E - G) * abs(F - H) - abs(up - down) * abs(left - right)
