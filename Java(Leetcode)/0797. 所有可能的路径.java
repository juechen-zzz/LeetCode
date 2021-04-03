/* 
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。

示例 1：

输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length == 0) {return ans;}
        dfs(graph, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[][] graph, int cur, List<Integer> path) {
        path.add(cur);
        if (cur == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        }
        for (int neigh : graph[cur]) {
            dfs(graph, neigh, path);
        }
        path.remove(path.size() - 1);
    }
}