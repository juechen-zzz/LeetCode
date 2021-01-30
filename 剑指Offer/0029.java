/* 
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */

import java.util.*;
public class Solution {
    private ArrayList<Integer> ans = new ArrayList<>();
    private PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length == 0 || k == 0 || k > input.length) {return ans;}
        for (int n : input) {
            if (pq.size() < k) {
                pq.offer(n);
            }
            else {
                if (n < pq.peek()) {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        
        for (Integer i : pq) {
            ans.add(i);
        }
        return ans;
    }
}