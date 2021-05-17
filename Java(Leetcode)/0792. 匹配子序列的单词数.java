/* 
给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。

示例:
输入: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
输出: 3
解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。

 */

// solution 1
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {map.put(w, map.getOrDefault(w, 0) + 1);}

        for (String cur : map.keySet()) {
            int j = 0;
            for (int i = 0; i < s.length() && j < cur.length(); i++) {
                if (cur.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            if (j == cur.length()) {ans += map.get(cur);}
        }
        
        return ans;
    }
}

// solution 2
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {map.put(c, new LinkedList<String>());}
        for (String w : words) {map.get(w.charAt(0)).addLast(w);}

        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<String> deque = map.get(c);
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                String w = deque.removeFirst();
                if (w.length() == 1) {count++;}
                else {
                    map.get(w.charAt(1)).addLast(w.substring(1));
                }
            }
        }

        return count;
    }
}
