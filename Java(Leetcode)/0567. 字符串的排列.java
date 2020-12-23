/* 
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False

 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) - need.get(c) == 0) {valid++;}
            }
            while (right - left >= s1.length()){
                if (valid == need.size()){return true;}
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d) - need.get(d) == 0) {valid--;}
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }
}