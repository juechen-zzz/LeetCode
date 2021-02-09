/* 
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 */

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {return 0;}
        int ans = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum >= 0) {sum += array[i];}
            else {sum = array[i];}
            if (sum > ans) {ans = sum;}
        }
        return ans;
    }
}