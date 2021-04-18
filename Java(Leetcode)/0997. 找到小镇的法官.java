/* 
在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

如果小镇的法官真的存在，那么：

小镇的法官不相信任何人。
每个人（除了小镇法官外）都信任小镇的法官。
只有一个人同时满足属性 1 和属性 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

 

示例 1：

输入：N = 2, trust = [[1,2]]
输出：2
示例 2：

输入：N = 3, trust = [[1,3],[2,3]]
输出：3
示例 3：

输入：N = 3, trust = [[1,3],[2,3],[3,1]]
输出：-1

 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        int n = trust.length;
        if (n == 0) {return N == 1 ? 1 : -1;}
        
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < n; i++) {graph[trust[i][0]][trust[i][1]] = 1;}

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            int vote = 0;
            for (int j = 1; j <= N && vote == 0; j++) {
                vote += graph[i][j];
            }

            int ticket = 0;
            if (vote > 0) {continue;}
            else {
                for (int k = 1; k <= N; k++) {
                    ticket += graph[k][i];
                }
            }

            if (ticket == N - 1) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}