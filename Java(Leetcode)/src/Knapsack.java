/**
 * @description: 背包问题
 * @author: Komorebi
 * @time: 2021/4/3 19:14
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] weights = new int[]{3, 5, 2, 3};
        int[] weights2 = new int[]{1, 2, 3, 3};
        int[] values = new int[]{5, 1, 4, 2};
        int[] count = new int[]{1, 2, 3, -1};
        int capacity = 6;
        int capacity2 = 10;

        System.out.println("0/1背包最大价值：" + zeroOneType(weights, values, capacity));
        System.out.println("完全背包最大价值：" + completeType(weights, values, capacity));
        System.out.println("混合背包最大价值：" + mixType(weights, values, count, capacity));
        System.out.println("二维背包最大价值：" + twoDiType(weights, values, count, capacity, capacity2));
    }

    /**
     * @description 0/1背包问题
     */
    private static int zeroOneType(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int cur = capacity; cur >= weights[i]; cur--) {
                dp[cur] = Math.max(dp[cur], dp[cur - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }

    /**
     * @description 完全背包问题
     */
    private static int completeType(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int cur = weights[i]; cur <= capacity; cur++) {
                dp[cur] = Math.max(dp[cur], dp[cur - weights[i]] + values[i]);
            }
        }

        return dp[capacity];
    }

    /**
     * @description 混合背包问题
     */
    private static int mixType(int[] weights, int[] values, int[] count, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {            // 属于 0/1 背包
                for (int cur = capacity; cur >= weights[i]; cur--) {
                    dp[cur] = Math.max(dp[cur], dp[cur - weights[i]] + values[i]);
                }
            }
            else  if (count[i] == -1) {       // 属于 完全 背包
                for (int cur = weights[i]; cur <= capacity; cur++) {
                    dp[cur] = Math.max(dp[cur], dp[cur - weights[i]] + values[i]);
                }
            }
            // 如果存在多重背包，则直接添加进数组，变成0/1中的一种
        }

        return dp[capacity];
    }

    /**
     * @description 二维背包问题
     */
    private static int twoDiType(int[] weights, int[] weights2, int[] values, int capacity, int capacity2) {
        int n = weights.length;
        int[][] dp = new int[capacity + 1][capacity2 + 1];

        for (int i = 0; i < n; i++) {
            for (int cur = capacity; cur >= weights[i]; cur--) {
                for (int cur2 = capacity2; cur2 >= weights2[i]; cur2--) {
                    dp[cur][cur2] = Math.max(dp[cur][cur2], dp[cur - weights[i]][cur2 - weights2[i]] + values[i]);
                }
            }
        }

        return dp[capacity][capacity2];
    }
}
