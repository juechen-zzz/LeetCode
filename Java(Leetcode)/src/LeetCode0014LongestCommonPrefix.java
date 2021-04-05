/**
 * @description:
 *      编写一个函数来查找字符串数组中的最长公共前缀。
 *      如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *      输入: ["flower","flow","flight"]
 *      输出: "fl"
 * 示例 2:
 *      输入: ["dog","racecar","car"]
 *      输出: ""
 *      解释: 输入不存在公共前缀。
 *
 * 时间复杂度：O(mn)  n是数组长度 m是minLength
 * 空间复杂度：O(1)
 */

public class LeetCode0014LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {return "";}
        else if (strs.length == 1) {return strs[0];}
        else {
            int minLength = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < minLength) {
                    minLength = strs[i].length();
                }
            }

            int idx = 0;
            while (idx < minLength) {
                char c = strs[0].charAt(idx);
                for (String s : strs) {
                    if (s.charAt(idx) != c) {
                        return strs[0].substring(0, idx);
                    }
                }
                idx++;
            }

            return strs[0].substring(0, idx);
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
