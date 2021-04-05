/* 
给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。

你需要返回给定数组中的重要翻转对的数量。

示例 1:

输入: [1,3,2,3,1]
输出: 2
示例 2:

输入: [2,4,3,5,1]
输出: 3
 */

class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {return 0;}
        return myMethod(nums, 0, nums.length - 1);
    }

    private int myMethod(int[] nums, int left, int right) {
        if (left == right) {return 0;}
        else {
            int mid = left + (right - left) / 2;
            int countLeft = myMethod(nums, left, mid);
            int countRight = myMethod(nums, mid + 1, right);
            int ans = countLeft + countRight;

            int i = left, j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long)nums[i] > 2 * (long)nums[j]) {j++;}
                ans += j - mid - 1;
                i++;
            }

            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                }
                else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                }
                else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    }
                    else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }

            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ans;
        }
    }
}