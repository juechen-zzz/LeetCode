/* 
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {return ans;}
        for (int i = 0; i < nums.length - 3; i++) {
            // 此处不能判断nums[i]和target的大小，然后break，因为可能target是负数
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {continue;}
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int total = nums[i] + nums[j] + nums[left] + nums[right];
                    if (total < target) {left++;}
                    else if (total > target) {right--;}
                    else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        ans.add(tmp);

                        while (left < right && nums[left] == nums[left + 1]) {left++;}
                        while (left < right && nums[right] == nums[right - 1]) {right--;}
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}