/* 
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    private ArrayList<String> ans = new ArrayList<>();
    
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {return ans;}
        StringBuilder s = new StringBuilder(str);
        Helper(s, 0);
        Collections.sort(ans);
        return ans;
    }
    
    public void Helper(StringBuilder s, int index) {
        if (index == s.length() - 1) {ans.add(s.toString());}
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) != s.charAt(i) || index == i) {
                Swap(s, index, i);
                Helper(s, index + 1);
                Swap(s, index, i);
            }
        }
    }
    
    public static void Swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}