/* 
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。



示例 1：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]

 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i , i + 10);
            if (count.containsKey(tmp) && count.get(tmp) == 1) {
                ans.add(tmp);
                count.put(tmp, 2);
            }
            else if (!count.containsKey(tmp)) {
                count.put(tmp, 1);
            }
        }

        return ans;
    }
}