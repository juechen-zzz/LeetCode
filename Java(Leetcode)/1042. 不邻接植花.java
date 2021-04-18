/* 
有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。

另外，所有花园 最多 有 3 条路径可以进入或离开.

你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。

以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。

 

示例 1：

输入：n = 3, paths = [[1,2],[2,3],[3,1]]
输出：[1,2,3]
解释：
花园 1 和 2 花的种类不同。
花园 2 和 3 花的种类不同。
花园 3 和 1 花的种类不同。
因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
示例 2：

输入：n = 4, paths = [[1,2],[3,4]]
输出：[1,2,1,2]
示例 3：

输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
输出：[1,2,3,4]

 */

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        /* 这是一道简单题，限制每个节点的度为3，同时提供四种颜色，因此不需要回溯 */
        /* 初始化节点，使用map保存节点与其临界点的关系 */
        /* 第一版本采用了内部类构建，参考评论区的HashMap更简洁 */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息 */
        for (int[] cur : paths) {
            int a = cur[0] - 1;
            int b = cur[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            /* 查看当前节点的所有邻接点的色彩 */
            boolean[] visited = new boolean[5];
            for (int adj : graph.get(i)) {
                visited[ans[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!visited[j]) {
                    ans[i] = j;
                }
            }
        }
        return ans;
    }
}