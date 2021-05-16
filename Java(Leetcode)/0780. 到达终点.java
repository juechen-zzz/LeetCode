/* 
从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。

给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。

示例:
输入: sx = 1, sy = 1, tx = 3, ty = 5
输出: True
解释:
可以通过以下一系列转换从起点转换到终点：
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

输入: sx = 1, sy = 1, tx = 2, ty = 2
输出: False

输入: sx = 1, sy = 1, tx = 1, ty = 1
输出: True

 */

// 超时
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty)
                return true;
            if (tx > ty) tx -= ty;
            else ty -= tx;
        }
        return false;
    }
}

// 回溯
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) {break;}
            if (tx > ty) {
                if (ty > sy) {tx %= ty;}
                else {return (tx - sx) % ty == 0;}
            }
            else {
                if (tx > sx) {ty %= tx;}
                else {return (ty - sy) % tx == 0;}
            }
        }
        return (tx == sx && ty == sy);
    }
}