/* 
有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。

示例 1：

输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2
示例 2：

输入：times = [[1,2,1]], n = 2, k = 1
输出：1

 */

class Solution {
    Map<Integer, Integer> dist = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        for (int node : graph.keySet()) {Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);}
        t

        dfs(graph, k, 0);

        int ans = 0;
        for (int num : dist.values()) {
            if (num == Integer.MAX_VALUE) {return -1;}
            ans = Math.max(ans, num);
        }
        return ans;
    }

    private void dfs(Map<Integer, List<int[]>> graph, int node, int time) {
        if (time >= dist.get(node)) {return;}
        dist.put(node, time);
        if (graph.containsKey(node)) {
            for (int[] info : graph.get(node)) {
                dfs(graph, info[0], time + info[1]);
            }
        }
    }
}