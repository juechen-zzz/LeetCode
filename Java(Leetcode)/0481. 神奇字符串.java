/* 
神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：

字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。

字符串 S 的前几个元素如下：S = “1221121221221121122 ......”

如果我们将 S 中连续的 1 和 2 进行分组，它将变成：

1 22 11 2 1 22 1 22 11 2 11 22 ......

并且每个组中 '1' 或 '2' 的出现次数分别是：

1 2 2 1 1 2 1 2 2 1 2 2 ......

你可以看到上面的出现次数就是 S 本身。

给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。

注意：N 不会超过 100,000。

示例：

输入：6
输出：3
解释：神奇字符串 S 的前 6 个元素是 “12211”，它包含三个 1，因此返回 3。

 */

class Solution {
    public int magicalString(int n) {
        if (n <= 0) {return 0;}
        if (n == 1) {return 1;}
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        int count = 1, i = 1, low = 0;
        char cur = '1';
        while (i < n) {
            //填的数量就由走的慢的指针决定
            char former = sb.charAt(low++);
            //每次把一种数字填充完，如果上次填的1，那么这次就是2
            cur = (cur == '1' ? '2' : '1');
            if (former == '1') {
                if (cur == '1') {count++;}
                sb.append(cur);
                i++;
            }
            else {
                if (cur == '1') {count += 2;}
                sb.append(cur);
                sb.append(cur);
                i += 2;
            }
        }

        //判断最后是否计入了 n 之后的 1，如有就去掉
        if (i == n && cur == '1') {count--;}
        if (i == n + 1 && cur == '1') {count -= 2;}
        return count;
    }
}