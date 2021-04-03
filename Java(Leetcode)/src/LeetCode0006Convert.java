import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *      将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *      比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *      L   C   I   R
 *      E T O E S I I G
 *      E   D   H   N
 *      之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

public class LeetCode0006Convert {
    private static String convert(String s, int numRows) {
        if (numRows == 1) {return s;}
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {goDown = !goDown;}
            curRow += goDown ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {ans.append(row);}
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int n = 3;
        System.out.println(convert(s, n).equals("LCIRETOESIIGEDHN"));
    }
}
