/* 
给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。

美式键盘 中：

第一行由字符 "qwertyuiop" 组成。
第二行由字符 "asdfghjkl" 组成。
第三行由字符 "zxcvbnm" 组成。

示例 1：

输入：words = ["Hello","Alaska","Dad","Peace"]
输出：["Alaska","Dad"]
示例 2：

输入：words = ["omk"]
输出：[]
示例 3：

输入：words = ["adsdf","sfd"]
输出：["adsdf","sfd"]

 */

class Solution {
    public String[] findWords(String[] words) {
        if (words == null) {return null;}

        List<String> ans = new ArrayList<>();
        String lines[] = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};

        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }
        
        return ans.toArray(new String[ans.size()]);
    }

    private boolean judge(String word, String[] lines) {
        boolean flag = true;
        String cur = null;

        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                cur = line;
                break;
            }
        }

        if (cur == null) {
            flag = false;
            return flag;
        }

        for (int i = 1; i < word.length(); i++) {
            if (cur.indexOf(word.charAt(i)) < 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}