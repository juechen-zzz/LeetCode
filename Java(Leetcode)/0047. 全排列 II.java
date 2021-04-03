/* 
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, track, visited);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> track, boolean[] visited) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, ans, track, visited);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }
}