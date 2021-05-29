/* 
你总共需要上 n 门课，课程编号依次为 0 到 n-1 。

有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。

给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。

对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。

请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。

注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。

示例 1：
输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
输出：[false,true]
解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。

示例 2：
输入：n = 2, prerequisites = [], queries = [[1,0],[0,1]]
输出：[false,false]
解释：没有先修课程对，所以每门课程之间是独立的。

示例 3：
输入：n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
输出：[true,true]

示例 4：
输入：n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
输出：[false,true]

示例 5：
输入：n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
输出：[true,false,true,false]

 */

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {graph[i] = new ArrayList<>();}

        // 建立邻接表、计算入度
        int[] inDegree = new int[numCourses];
        for (int[] tmp : prerequisites) {
            inDegree[tmp[1]]++;
            graph[tmp[0]].add(tmp[1]);
        }

        Set<Integer>[] visited = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {     // 只计算入度为0的节点
                dfs(i, graph, visited);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] cur : queries) {
            ans.add(visited[cur[0]].contains(cur[1]));
        }

        return ans;
    }

    private static void dfs(int u, List<Integer>[] graph, Set<Integer>[] visited) {
        if (visited[u] != null) {return;}

        visited[u] = new HashSet<>();
        visited[u].add(u);

        // 将子节点的后修课程加入父节点的后修课程
        for (int neigh : graph[u]) {
            dfs(neigh, graph, visited);
            for (int cur : visited[neigh]) {
                visited[u].add(cur);
            }
        }
    }
}