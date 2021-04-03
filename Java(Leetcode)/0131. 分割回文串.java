/* 
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

 */

class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {return ans;}
        Deque<String> path  = new LinkedList<>();

        backtrack(s, 0, len, path);
        return ans;
    }

    public void backtrack(String s, int start, int len, Deque<String> path) {
        if (start == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!checkpalindrome(s, start, i)) {continue;}
            path.offerLast(s.substring(start, i + 1));
            backtrack(s, i + 1, len, path);
            path.removeLast();
        }
    }

    public boolean checkpalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {return false;}
            left++;
            right--;
        }
        return true;
    }
}
