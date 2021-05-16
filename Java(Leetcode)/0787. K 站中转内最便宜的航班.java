/* 
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。

 

示例 1：

输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
输出: 200
解释: 
城市航班图如下


从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
示例 2：

输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
输出: 500
解释: 
城市航班图如下


从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 
 */

// BFS
import javafx.util.Pair;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {graph.add(new ArrayList<Pair<Integer, Integer>>());}
        for (int[] cur : flights) {graph.get(cur[0]).add(new Pair(cur[1], cur[2]));}

        int ans = Integer.MAX_VALUE;
        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(new Pair(src, new Pair(0, 0)));

        while (!queue.isEmpty() && queue.peek().getValue().getKey() <= k + 1) {
            Pair<Integer, Pair<Integer, Integer>> tmp = queue.peek();
            if (tmp.getKey() == dst) {ans = Math.min(ans, tmp.getValue().getValue());}

            for (Pair<Integer, Integer> m : graph.get(tmp.getKey())) {
                if (m.getValue() + tmp.getValue().getValue() < ans) {
                    queue.offer(new Pair(m.getKey(), new Pair(tmp.getValue().getKey() + 1, m.getValue() + tmp.getValue().getValue())));
                }
            }

            queue.poll();
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// DFS
class Solution {
    private int[][] graph;
    private boolean[] visited;
    private int ans = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = Math.min(k, n - 2);
        this.graph = new int[n][n];
        this.visited = new boolean[n];
        for (int[] cur : flights) {graph[cur[0]][cur[1]] = cur[2];}

        dfs(src, dst, k + 1, 0);

        if (ans == Integer.MAX_VALUE) {return -1;}
        return ans;
    }

    private void dfs(int src, int dst, int k, int cost) {
        if (src == dst) {
            ans = cost;
            return;
        }

        if (k == 0) {return;}

        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] > 0) {
                if (visited[i]) {continue;}
                if (cost + graph[src][i] > ans) {continue;}

                visited[i] = true;
                dfs(i, dst, k - 1, cost + graph[src][i]);
                visited[i] = false;
            }
        }
    }
}

// Dijkstra 算法
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {return price;}

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0 ) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i]  , k - 1});
                    }
                }
            }
        }
        return -1;
    }
}