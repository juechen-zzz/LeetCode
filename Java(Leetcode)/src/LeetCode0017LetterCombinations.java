import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *      给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *      输入："23"
 *      输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 时间复杂度：O(3^n * 4^m)   n对应3种情况的个数，m对应四种情况的个数
 * 空间复杂度：O(n+m)
 */

public class LeetCode0017LetterCombinations {
    private static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static StringBuilder sb = new StringBuilder();
    private static List<String> ans = new ArrayList<>();

    private static List<String> letterCombiinations(String digits) {
        if (digits.length() == 0) {return ans;}
        backtrack(digits, 0);
        return ans;
    }

    private static void backtrack(String digits, int idx) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String val = map[digits.charAt(idx) - '2'];
        for (char c : val.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombiinations(digits));
    }
}
