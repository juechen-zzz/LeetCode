/* 
    斐波那契数列
 */

public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 2] + res[i -1];
        }
        return res[n - 1];
    }
}