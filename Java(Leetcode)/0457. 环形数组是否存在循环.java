/* 
存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：

如果 nums[i] 是正数，向前 移动 nums[i] 步
如果 nums[i] 是负数，向后 移动 nums[i] 步
因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。

数组中的 循环 由长度为 k 的下标序列 seq ：

遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
所有 nums[seq[j]] 应当不是 全正 就是 全负
k > 1
如果 nums 中存在循环，返回 true ；否则，返回 false 。

示例 1：

输入：nums = [2,-1,1,2,2]
输出：true
解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
示例 2：

输入：nums = [-1,2]
输出：false
解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
示例 3:

输入：nums = [-2,1,-1,-2,-2]
输出：false
解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
所有 nums[seq[j]] 应当不是全正就是全负。

 */

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) {return false;}
        if (n == 2 && nums[0] * nums[1] <= 0) {return false;}

        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {nums2[i] = nums[i];}

        for (int i = 0; i < n; i++) {
            if (nums2[i] == 0) {continue;}
            else {
                int curNum = nums[i], curIndex = i;
                nums2[i] = 0;
                int circleLen = 0;
                while (true) {
                    int nextIndex = curIndex + curNum;
                    if (nextIndex >= 0) {nextIndex %= n;}
                    else {nextIndex = n - ((0 - nextIndex) % n);}

                    int nextNum = nums[nextIndex];
                    if (nextIndex == curIndex || nextNum * curNum <= 0) {break;}

                    if (circleLen > n) {return true;}

                    circleLen++;
                    nums2[nextIndex] = 0;
                    curNum = nextNum;
                    curIndex = nextIndex;
                }
            }
        }

        return false;
    }
}