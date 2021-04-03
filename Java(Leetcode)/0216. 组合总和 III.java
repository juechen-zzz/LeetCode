/* 
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, 9);
        return ans;
    }

    public void dfs(int k, int n, int start, int end) {
        if (tmp.size() + (end - start + 1) < k || tmp.size() > k) {return;}

        if (tmp.size() == k) {
            int sum = 0;
            for (int num : tmp) {sum += num;}
            if (sum == n) {
                ans.add(new ArrayList<>(tmp));
                return;
            }
        }
        
        dfs(k, n, start + 1, end);

        tmp.add(start);
        dfs(k, n, start + 1, end);
        tmp.remove(tmp.size() - 1);
    }
}