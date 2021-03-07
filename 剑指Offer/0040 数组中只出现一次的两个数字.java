/* 
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int n : array) {
            if (set.contains(n)) {
                set.remove(n);
            }
            else {
                set.add(n);
            }
        }
        
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < 2; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}