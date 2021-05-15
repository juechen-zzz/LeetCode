/* 
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""

 */

class Solution {
    public String reorganizeString(String s) {
        char[] charArray = s.toCharArray();
        int[] dist = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {dist[charArray[i] - 'a']++;}

        int maxCount = 0, alphabet = 0;
        for (int i = 0; i < 26; i++) {
            if (dist[i] > maxCount) {
                maxCount = dist[i];
                alphabet = i;
                if (maxCount > (n + 1) / 2) {return "";}
            }
        }

        char[] ans = new char[n];
        int idx = 0;
        while (dist[alphabet] > 0) {
            ans[idx] = (char)(alphabet + 'a');
            idx += 2;
            dist[alphabet]--;
        }

        for (int i = 0; i < 26; i++) {
            while (dist[i] > 0) {
                if (idx >= n) {idx = 1;}
                ans[idx] = (char)(i + 'a');
                idx += 2;
                dist[i]--;
            }
        }

        return new String(ans);
    }
}