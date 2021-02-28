/* 
如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

 

示例 1：

输入：[1,2,2,3]
输出：true
示例 2：

输入：[6,5,4,4]
输出：true
示例 3：

输入：[1,3,2]
输出：false
示例 4：

输入：[1,2,4,5]
输出：true
示例 5：

输入：[1,1,1]
输出：true

 */

class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3) {return true;}
        int len = A.length;
        int countIncrease = 0, countDecrease = 0;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] <= A[i + 1])
                countIncrease++;
            if (A[i] >= A[i + 1])
                countDecrease++;
        }
        return countIncrease == len - 1 || countDecrease == len - 1;
    }
}