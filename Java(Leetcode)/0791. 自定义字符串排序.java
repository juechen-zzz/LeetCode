/* 
字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。

S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。

返回任意一种符合条件的字符串T。

示例:
输入:
S = "cba"
T = "abcd"
输出: "cbad"
解释: 
S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 
由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。

 */

class Solution {
    public String customSortString(String order, String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {count[c - 'a']++;}

        StringBuilder ans = new StringBuilder();
        // 先找出在 str 中出现的所有的 order 的元素，并且将这些元素按照 order 中出现的相对顺序排序
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
            count[c - 'a'] = 0;
        }

        // 将 str 中出现的但不在 order 中的元素添加到字符串时，无序关注顺序，因为这些元素并没有在 order 中出现，不需要满足排序关系
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}