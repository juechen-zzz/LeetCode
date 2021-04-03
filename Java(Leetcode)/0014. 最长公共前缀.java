/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {return "";}
        else if (strs.length == 1) {return strs[0];}
        else {
            int minLength = strs[0].length();
            for (int i = 1; i < strs.length; i++){
                if (strs[i].length() < minLength) {
                    minLength = strs[i].length();
                }
            }
            
            int index = 0;
            while (index < minLength){
                char ch = strs[0].charAt(index);
                for (int i = 0; i < strs.length; i++){
                    if (strs[i].charAt(index) != ch) {
                        return strs[0].substring(0, index);
                    }
                }
                index++;
            }
            return strs[0].substring(0, index);
        }
    }
}