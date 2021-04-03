/* 
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 

示例：

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

 */

// 递归
class Solution {
    public String removeDuplicates(String S) {
        int n = S.length();
        for (int i = 1; i < n; i++){
            if (S.charAt(i - 1) == S.charAt(i)){
                return removeDuplicates(S.substring(0, i - 1) + removeDuplicates(S.substring(i + 1)));
            }
        }
        return S;
    }
}

// 栈
class Solution {
    public String removeDuplicates(String S) { 
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : S.toCharArray()) {
            if (sbLength != 0 && c == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            }
            else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
