/* 
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

 */

class Solution {
    public String reverseWords(String s) {
        String[] tmp = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < tmp.length; i++) {
            for (int j = tmp[i].length() - 1; j >= 0; j--) {
                ans.append(tmp[i].charAt(j));
            }
            if (i != tmp.length - 1) {
                ans.append(" ");
            }
        }

        return new String(ans);
    }
}