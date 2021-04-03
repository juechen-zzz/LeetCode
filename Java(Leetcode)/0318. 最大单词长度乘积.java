/* 
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

示例 1:

输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。
示例 2:

输入: ["a","ab","abc","d","cd","bcd","abcd"]
输出: 4 
解释: 这两个单词为 "ab", "cd"。
示例 3:

输入: ["a","aa","aaa","aaaa"]
输出: 0 
解释: 不存在这样的两个单词。

 */

class Solution {
    public int maxProduct(String[] words) {
        int[] wordToNum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int num = 0;
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                num = num | (1 << index);
            }
            wordToNum[i] = num;
        }

        int ans = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordToNum[i] & wordToNum[j]) != 0) {continue;}
                ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }

        return ans;
    }
}