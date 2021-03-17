/* 
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1：

输入："hello"
输出："holle"
示例 2：

输入："leetcode"
输出："leotcede"

 */

class Solution {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s.length() == 0) {return s;}
        int left = 0, right = s.length() - 1;
        char[] c = new char[s.length()];

        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!vowels.contains(c1)) {
                c[left++] = c1;
            }
            else if (!vowels.contains(c2)) {
                c[right--] = c2;
            }
            else {
                c[left++] = c2;
                c[right--] = c1;
            }
        }

        return String.valueOf(c);
    }
}