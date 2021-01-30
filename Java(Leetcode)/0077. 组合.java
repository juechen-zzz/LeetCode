/* 
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }

    public void dfs(int n, int k, int cur) {
        if (tmp.size() + (n - cur + 1) < k) {return;}

        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(cur);
        dfs(n, k, cur + 1);
        tmp.remove(tmp.size() - 1);

        dfs(n, k, cur + 1);
    }
}