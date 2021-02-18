/* 
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]

 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        int n = s.length();

        // 第 1 步：动态规划得到是否可以划分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        List<String> ans = new ArrayList<>();
        if (dp[n]) {
            Deque<String> deque = new LinkedList<>();
            dfs(s, n, wordDict, dp, deque, ans);
            return ans;
        }

        return ans;
    }

    public void dfs(String s, int len, List<String> wordDict, boolean[] dp, Deque<String> deque, List<String> ans) {
        if (len == 0) {
            ans.add(String.join(" ", deque));
            return;
        }

        for (int i = len - 1; i >= 0; i--) {
            String tmp = s.substring(i, len);
            if (dp[i] && wordDict.contains(tmp)) {
                deque.offerFirst(tmp);
                dfs(s, i, wordDict, dp, deque, ans);
                deque.pollFirst();
            }
        }
    }
}