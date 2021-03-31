import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *      给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *      输入: s = "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *      输入: s = "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)   表示s中的字符个数，最多26个
 */

// 维持一个滑动窗口，一定窗口中出现某个字符出现超过一次，则左指针开始右移
public class LeetCode0003 {
    private static int lengthofLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int ans = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthofLongestSubstring(s));
    }
}
