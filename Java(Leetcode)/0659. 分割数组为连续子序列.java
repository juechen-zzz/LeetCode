/* 
给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。

如果可以完成上述分割，则返回 true ；否则，返回 false 。

示例 1：

输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5
示例 2：

输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5
示例 3：

输入: [1,2,3,4,4,5]
输出: False

 */

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {map.put(x, new PriorityQueue<Integer>());}

            if (map.containsKey(x - 1)) {
                int preLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {map.remove(x - 1);}
                map.get(x).offer(preLength + 1);
            }
            else {
                map.get(x).offer(1);
            }
        }

        for (int k : map.keySet()) {
            PriorityQueue<Integer> queue = map.get(k);
            if (queue.peek() < 3) {return false;}
        }

        return true;
    }
}