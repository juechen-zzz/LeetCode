/* 
在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。

red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。

返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。

 

示例 1：

输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
输出：[0,1,-1]
示例 2：

输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
输出：[0,1,-1]
示例 3：

输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
输出：[0,-1,-1]
示例 4：

输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
输出：[0,1,2]
示例 5：

输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
输出：[0,1,1]

 */

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		List<List<Integer>> rg = new ArrayList<>();//这是 红色线的集合
		List<List<Integer>> bg = new ArrayList<>();//这是 蓝色线的集合

		for (int i = 0; i < n; i++) {
			//初始化两条线的集合
			rg.add(new ArrayList<>());
			bg.add(new ArrayList<>());
		}

		//根据数组改变 红蓝色线 集合
		for (int[] red : red_edges) {rg.get(red[0]).add(red[1]);}
		for (int[] blue : blue_edges) {bg.get(blue[0]).add(blue[1]);}

		int[][] ans = new int[n][2];
		for (int[] ansColor : ans) {
			//初始化所有距离为MAX
			ansColor[0] = Integer.MAX_VALUE;
			ansColor[1] = Integer.MAX_VALUE;
		}
		//出发点距离设为0
		ans[0][0] = 0;
		ans[0][1] = 0;

		dfs(ans, 0, 0, rg, bg);     //从红色线出发
		dfs(ans, 1, 0, rg, bg);     //从蓝色线出发

		int[] finalAns = new int[n];
		for (int i = 0; i < n; i++) {
			//取最小值  没有的话为-1
			finalAns[i] = Math.min(ans[i][0], ans[i][1]);
			if (finalAns[i] == Integer.MAX_VALUE)
				finalAns[i] = -1;
		}
		return finalAns;
	}

	public void dfs(int[][] ans, int color, int i, List<List<Integer>> rg, List<List<Integer>> bg) {
		List<List<Integer>> g = color == 0 ? rg : bg;		//选择 红蓝色 线
		for (int j : g.get(i)) {
			//遍历该线段 以 i 为出发点的终点
			if (ans[i][color] + 1 < ans[j][1 - color]) {
				//判断 0 -> i -> j 的长度是否 比 已有的 0 -> j 的路径长度长 若是 则更新 
				//!!!这个判断是整个算法的核心 
				//当在也找不到更短的路径时 dfs会停止搜索 否则继续
				ans[j][1 - color] = ans[i][color] + 1;
                dfs(ans, 1 - color, j, rg, bg);
            }
		}
	}
}
