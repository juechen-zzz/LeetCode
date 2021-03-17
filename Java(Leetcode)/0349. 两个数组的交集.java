/* 
给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();      
        for(int i : nums1){set1.add(i);}
        for(int i : nums2){
            if (set1.contains(i)){
                set2.add(i);
            }
        }
        int[] ans = new int[set2.size()];
        int index = 0;
        for(int i : set2){
            ans[index++] = i;
        }
        return ans;
    }
}