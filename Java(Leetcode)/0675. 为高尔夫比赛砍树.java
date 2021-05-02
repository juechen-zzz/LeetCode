/* 
你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：

0 表示障碍，无法触碰
1 表示地面，可以行走
比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。

你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。

你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。

可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。

示例 1：
输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
输出：6
解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
示例 2：


输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
输出：-1
解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
示例 3：

输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
输出：6
解释：可以按与示例 1 相同的路径来砍掉所有的树。
(0,0) 位置的树，可以直接砍去，不用算步数。

 */

class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.size() == 0 || forest.get(0).size() == 0) {return 0;}

        int n = forest.size(), m = forest.get(0).size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(forest.get(i).get(j) > 1){   
                    minHeap.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int ans = 0;
        while (!minHeap.isEmpty()) {
            int[] lowest = minHeap.poll();
            int step = minStep(forest, start, lowest);
            if (step < 0) {return -1;}

            ans += step;
            start[0] = lowest[0];
            start[1] = lowest[1];
        }

        return ans;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] lowest) {
        int n = forest.size(), m = forest.get(0).size();
        int step = 0;

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == lowest[0] && cur[1] == lowest[1]) {return step;}

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY] || forest.get(nextX).get(nextY) == 0) {continue;}

                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
            step++;
        }

        return -1;
    }
}