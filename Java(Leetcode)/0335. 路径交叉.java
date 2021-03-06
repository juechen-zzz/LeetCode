/* 
给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。

编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。

示例 1:

┌───┐
│   │
└───┼──>
    │

输入: [2,1,1,2]
输出: true 

 */


class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) {return false;}
        for (int i = 3; i < n; i++) {
            if (distance[i - 3] >= distance[i - 1] && distance[i - 2] <= distance[i]) {return true;}
            if (i > 3) {
                if (distance[i - 4] + distance[i] >= distance[i - 2] && distance[i - 3] == distance[i - 1]) {return true;}
            }
            if (i > 4) {
                if (distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 2] >= distance[i - 4]
                && distance[i - 5] + distance[i - 1] >= distance[i - 3] && distance[i - 1] <= distance[i - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}