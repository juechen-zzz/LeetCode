import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *      给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *      输入: "III"
 *      输出: 3
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

public class LeetCode0013RomanToInt {
    private static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length();){
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            }
            else {
                ans += map.get(s.substring(i, i+1));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }
}
