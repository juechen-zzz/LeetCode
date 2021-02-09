/* 
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */

import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int t = map.get(str.charAt(i));
                t++;
                map.put(str.charAt(i), t);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {return i;}
        }
        return -1;
    }
}