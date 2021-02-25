/* 
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

如果存在则返回 true，不存在返回 false。

 

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:

输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false

 */

// time
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int n : set) {
                if (Math.abs(n - nums[i]) <= t) {return true;}
            }
            set.add(nums[i]);
            if (set.size() > k) {set.remove(nums[i - k]);}
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {set.remove((long)nums[i - k - 1]);}
            // 返回在这个集合中大于或者等于给定元素的最小元素
            Long low = set.ceiling((long) nums[i] - t);
            if (low != null && low <= (long)nums[i] + t) {return true;}
            set.add((long) nums[i]);
        }
        return false;
    }
}