/* 
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回符合要求的最少分割次数。

示例:

输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

 */

// DP
class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len < 2) {return 0;}

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {dp[i] = i;}

        for (int i = 1; i < len; i++) {
            if (checkPalindrome(s, 0, i)) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (checkPalindrome(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {return false;}
            left++;
            right--;
        }
        return true;
    }
}

// 2 超时
class Solution {
    List<List<String>> ans = new ArrayList<>();

    public int minCut(String s) {
        int len = s.length();
        if (len == 0) {return 0;}
        Deque<String> path = new LinkedList<>();

        backtrack(s, 0, len, path);
        
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++) {
            tmp = Math.min(tmp, ans.get(i).size());
        }
        return tmp - 1;
    }

    public void backtrack(String s, int start, int len, Deque<String> path) {
        if (start == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {continue;}
            path.offerLast(s.substring(start, i + 1));
            backtrack(s, i + 1, len, path);
            path.removeLast();
        }
    }

    public boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {return false;}
            left++;
            right--;
        }
        return true;
    }
}