/* 
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution {
    public int JumpFloorII(int target) {
        if (target == 1) {return 1;}
        if (target == 2) {return 2;}
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp > 0) {
                sum += dp[tmp];
                tmp--;
            }
            dp[i] = sum + 1;
        }
        return dp[target];
    }
}