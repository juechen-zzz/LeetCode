import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 背包问题：一个数组[a,b,c]，选择其中的几个，和为给定值，返回是否能实现
 * @author: Komorebi
 * @time: 2021/3/21 19:56
 * 测试样例：
 * 3 200
 * 100 100 120
 * 3 210
 * 100 100 120
 * 3 220
 * 100 100 120
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            // 第一行的一个数字
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();

            // 后续的n行数据
            List<Integer> nums = new ArrayList<>();
            String[] tmp = sc.nextLine().split(" ");
            for (int i = 0; i < tmp.length; i++) {
                nums.add(Integer.parseInt(tmp[i]));
            }

            MyMethod(nums, n, m);
        }
    }

    public static void MyMethod(List<Integer> nums, int n, int m) {
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= nums.get(i) && dp[j - nums.get(i)]) {
                    dp[j] = true;
                }
            }
        }

        if (dp[m]) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
