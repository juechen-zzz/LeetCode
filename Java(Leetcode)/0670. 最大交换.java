/* 
给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

示例 1 :

输入: 2736
输出: 7236
解释: 交换数字2和数字7。
示例 2 :

输入: 9973
输出: 9973
解释: 不需要交换。

 */

class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] charArray = s.toCharArray();

        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[charArray[i] - '0'] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(charArray, i, last[d]);
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        
        return num;
    }

    private static void swap(char[] charArray, int index1, int index2) {
        char tmp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = tmp;
    }
}