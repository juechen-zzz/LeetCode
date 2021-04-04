/* 
给定一个 不含重复 单词的字符串数组 words ，编写一个程序，返回 words 中的所有 连接词 。

连接词 的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。

 

示例 1：

输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
解释："catsdogcats"由"cats", "dog" 和 "cats"组成; 
     "dogcatsdog"由"dog", "cats"和"dog"组成; 
     "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
示例 2：

输入：words = ["cat","dog","catdog"]
输出：["catdog"]

 */


class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            if (myMethod(s, set, 0)) {
                ans.add(s);
            }
        }
        return ans;
    }

    private boolean myMethod(String s, Set<String> set, int index) {
        if (set.contains(s) && index != 0) {return true;}
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(0, i);
            if (set.contains(tmp)) {
                if (myMethod(s.substring(i), set, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}