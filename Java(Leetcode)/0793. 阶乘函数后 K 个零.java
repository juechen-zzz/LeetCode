/* 
f(x) 是 x! 末尾是 0 的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 ）

例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。给定 K，找出多少个非负整数 x ，能满足 f(x) = K 。

示例 1：

输入：K = 0
输出：5
解释：0!, 1!, 2!, 3!, and 4! 均符合 K = 0 的条件。
示例 2：

输入：K = 5
输出：0
解释：没有匹配到这样的 x!，符合 K = 5 的条件。

 */

class Solution {
    public int preimageSizeFZF(long k) {
        long low = k, high = 10 * k + 1;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long zmid = myMethod(mid);
            if (zmid == k) {return 5;}
            else if (zmid < k) {low = mid + 1;}
            else {high = mid;}
        }
        return 0;
    }

    public long myMethod(long x) {
        if (x == 0) {return 0;}
        return x / 5 + myMethod(x / 5);
    }
}