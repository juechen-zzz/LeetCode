/* 
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {return ans;}
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] > 0){break;}
            if (i > 0 && nums[i] == nums[i - 1]){continue;}

            int first = i, left = i + 1, right = nums.length - 1;
            while (left < right){
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {left++;}
                else if (total > 0) {right--;}
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);

                    while (left < right && nums[left] == nums[left + 1]) {left++;}
                    while (left < right && nums[right] == nums[right - 1]) {right--;}
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}