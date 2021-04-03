import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *      给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *      可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 * 时间复杂度：O(n)  n为数组长度
 * 空间复杂度：O(n)
 */

public class LeetCode0001TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        // 用一个Map存对应的 值-索引 组合，判断target-nums[i]是否存在，存在即返回
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(nums, target);
        printArray(ans);
    }
}
