/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

// 1 用 ArrayList
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, ArrayList<Integer> track){
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // 排除不合法的选择
            if (track.contains(nums[i])){       // O(N)时间复杂度
                continue;
            }
            // 做选择
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size()-1);
        }
    }
}

// 2 用 LinkedList
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track){
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // 排除不合法的选择
            if (track.contains(nums[i])){       // O(N)时间复杂度
                continue;
            }
            // 做选择
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
