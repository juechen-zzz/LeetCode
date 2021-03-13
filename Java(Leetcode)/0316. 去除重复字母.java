/* 
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

示例 1：

输入：s = "bcabc"
输出："abc"
示例 2：

输入：s = "cbacdcbc"
输出："acdb"

 */

class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new LinkedList<>();
        int[] count = new int[26];
        boolean[] exists = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (!exists[tmp - 'a']) {
                while (!deque.isEmpty() && deque.peekLast() > tmp && count[deque.peekLast() - 'a'] > 0) {
                    exists[deque.peekLast() - 'a'] = false;
                    deque.removeLast();
                }
                exists[tmp - 'a'] = true;
                deque.offerLast(tmp);
            }
            count[tmp - 'a']--;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : deque) {
            ans.append(c);
        }

        return ans.toString();
    }
}