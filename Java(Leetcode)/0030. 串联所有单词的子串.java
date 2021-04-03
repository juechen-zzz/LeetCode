/* 
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

 */


// 滑动窗口
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {return ans;}

        int wordLength = words[0].length(), wordNum = words.length;
        int targetLength = wordLength * wordNum;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - targetLength + 1; i++) {
            String tmp = s.substring(i, i + targetLength);
            HashMap<String, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < targetLength; j += wordLength) {
                String tempWord = tmp.substring(j, j+ wordLength);
                tempMap.put(tempWord, tempMap.getOrDefault(tempWord, 0) + 1);
            }
            if (tempMap.equals(map)) {ans.add(i);}
        }

        return ans;
    }
}