/**
 * @description:
 *      给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *      输入: 123
 *      输出: 321
 *
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */

public class LeetCode0007Reverse {
    private static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {return 0;}
            ans = ans * 10 + tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1312313251;
        System.out.println(reverse(n));
    }
}
