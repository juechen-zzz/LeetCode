/*
    int ans = Integer.MIN_VALUE;

    int[] n = new int[]{1, 2}

    int[] dp = new int[10];
    Arrays.fill(dp, 2);

ArrayList:
    List<Integer> nums = new ArrayList<Integer>();
    nums.add(1)
    nums.get(1)

    List<List<Integer>> res = new LinkedList<>();

return:
    return dp[amount] > amount ? -1 : dp[amount];
*/

import java.util.*;

import static java.util.Collections.*;

public class Test{
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();

        double result = Math.pow(4, 2);
        System.out.println(result);

        int[] nums = new int[3];
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);

        int n = 23;
        char[][] board = new char[n][n];
        for (char[] i : board){
            Arrays.fill(i, '.');
        }
        System.out.println(board);


    }
}