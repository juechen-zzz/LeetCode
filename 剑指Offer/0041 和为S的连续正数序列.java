/* 
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
 */

import java.util.*;
public class Solution {
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if (sum == 0) {return ans;}
        int left = 1, right = 2;
        while (left < right) {
            int curSum = (left + right) * (right - left + 1) / 2;
            if (curSum == sum) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {tmp.add(i);}
                ans.add(new ArrayList<>(tmp));
                tmp.clear();
                right++;
            }
            else if (curSum < sum) {right++;}
            else {left++;}
        }
        return ans;
    }
}
