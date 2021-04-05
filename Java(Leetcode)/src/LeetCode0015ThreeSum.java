import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *      给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *      请你找出所有满足条件且不重复的三元组。
 *      注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *      给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *      满足要求的三元组集合为：
 *      [
 *        [-1, 0, 1],
 *        [-1, -1, 2]
 *      ]
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(logn)  排序
 */

public class LeetCode0015ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {return ans;}

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {break;}
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {left++;}
                else if (total > 0) {right--;}
                else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    while (left < right && nums[left] == nums[left + 1]) {left++;}
                    while (left < right && nums[right] == nums[right - 1]) {right--;}
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}