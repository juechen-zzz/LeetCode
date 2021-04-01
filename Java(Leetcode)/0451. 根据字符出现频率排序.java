/* 
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

 */
// 桶排序
class Solution {
    public String frequencySort(String s) {
        if (s.isEmpty() || s.length() == 1) {return s;}

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // 构造一个桶的集合（即一系列桶），桶的个数为 s 的长度 +1，因为 buckets[0] 没有意义
        // 目的是将出现频率为 i 的字符放到第 i 个桶里（即 buckets[i]）
        List<Character>[] buckets = new List[s.length() + 1];

        for (char key : count.keySet()) {
            // 某个字符在 HashMap 中的 Value 是几就会被放到第几个桶里
            int value = count.get(key);
            if (buckets[value] == null) {
                // 如果某个桶还未放入过字符（即未初始化），则初始化其为一个数组
                buckets[value] = new ArrayList<Character>();
            }
            buckets[value].add(key); // 然后将字符放到桶中
        }

        StringBuilder ans = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; --i) {
            // 遍历每个桶
            if (buckets[i] != null) {
                // 如果桶里有字符
                for (char j : buckets[i]) {
                    // 遍历桶里的每个字符
                    for (int k = i; k > 0; --k) {
                        // 字符出现了几次就向 ans 中添加几次该字符
                        ans.append(j);
                    }
                }
            }
        }

        return ans.toString();
    }
}

// HashMap排序
class Solution {
    public String frequencySort(String s) {
        if (s.isEmpty() || s.length() == 1) {return s;}

        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> curList = new ArrayList<>(count.entrySet());
        curList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < curList.size(); i++) {
            for (int j = 0; j < curList.get(i).getValue(); j++) {
                ans.append(curList.get(i).getKey());
            }
        }
        
        return ans.toString();
    }
}