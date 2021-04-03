/* 
给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。



示例 1：

输入：words = ["abcd","dcba","lls","s","sssll"]
输出：[[0,1],[1,0],[3,2],[2,4]] 
解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2：

输入：words = ["bat","tab","cat"]
输出：[[0,1],[1,0]] 
解释：可拼接成的回文串为 ["battab","tabbat"]
示例 3：

输入：words = ["a",""]
输出：[[0,1],[1,0]]

 */

class TrieNode {
    public TrieNode[] children;
    public int index;
    public List<Integer> suffixs;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.index = -1;
        this.suffixs = new ArrayList<>();
    }
}
class Solution {
    private TrieNode root;

    public List<List<Integer>> palindromePairs(String[] words) {
        this.root = new TrieNode();
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            TrieNode cur = root;

            if (isPalindrome(word.substring(0))) {cur.suffixs.add(i);}
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                if (isPalindrome(word.substring(j + 1))) {cur.suffixs.add(i);}
            }
            cur.index = i;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            TrieNode cur = root;

            int j = 0;
            for (; j < word.length(); j++) {
                if (isPalindrome(word.substring(j)) && cur.index != -1) {
                    ans.add(Arrays.asList(i, cur.index));
                }

                int index = word.charAt(j) - 'a';
                if (cur.children[index] == null) {break;}
                cur = cur.children[index];
            }

            if (j == word.length()){
                for (int k : cur.suffixs){
                    if (k != i)
                        ans.add(Arrays.asList(i, k));
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}