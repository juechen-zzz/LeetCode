/* 
在有向图中，从某个节点和每个转向处开始出发，沿着图的有向边走。如果到达的节点是终点（即它没有连出的有向边），则停止。

如果从起始节点出发，最后必然能走到终点，就认为起始节点是 最终安全 的。更具体地说，对于最终安全的起始节点而言，存在一个自然数 k ，无论选择沿哪条有向边行走 ，走了不到 k 步后必能停止在一个终点上。

返回一个由图中所有最终安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。

该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。



示例 1：


输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
输出：[2,4,5,6]
解释：示意图如上。

 */

//当我们第一次访问一个节点时，我们把它从白色变成灰色，并继续搜索与它相连的节点。
// 如果在搜索过程中我们遇到一个灰色的节点，那么说明找到了一个环，此时退出搜索，所有的灰色节点保持不变（即从任意一个灰色节点开始，都能走到环中），
// 如果搜索过程中，我们没有遇到灰色的节点，那么在回溯到当前节点时，我们把它从灰色变成黑色，即表示它是一个安全的节点。
// 时间复杂度：O(N + E)
// 空间复杂度：O(N)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, color, graph)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) {return color[node] == 2;}

        color[node] = 1;
        for (int neigh : graph[node]) {
            if (color[neigh] == 2) {continue;}
            if (color[neigh] == 1 || !dfs(neigh, color, graph)) {return false;} 
        }

        color[node] = 2;
        return true;
    }
}