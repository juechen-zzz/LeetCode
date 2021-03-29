/* 
一个强密码应满足以下所有条件：

由至少6个，至多20个字符组成。
至少包含一个小写字母，一个大写字母，和一个数字。
同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。

插入、删除、替换任一字符都算作一次修改。

 */

class Solution {
    public int strongPasswordChecker(String password) {
        int len = password.length();
        if (len == 0) {return 6;}
        char[] array = password.toCharArray();

        int low = 1, up = 1, num = 1, count = 1;
        if (Character.isLowerCase(array[0])) {low = 0;}
        else if (Character.isUpperCase(array[0])) {up = 0;}
        else if (Character.isDigit(array[0])) {num = 0;}

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a % 3 - b % 3);

        for (int i = 1; i < len; i++) {
            if (low == 1 && Character.isLowerCase(array[i])) {low = 0;}
            else if (up == 1 && Character.isUpperCase(array[i])) {up = 0;}
            else if (num == 1 && Character.isDigit(array[i])) {num = 0;}

            if (array[i] != array[i - 1]) {
                if (count >= 3) {queue.add(count);}
                count = 1;
            } else {
                count++;
            }
        }

        if (count >= 3) {queue.add(count);}
        int ans = 0, all = low + up + num;

        if (len < 6) {return Math.max(6 - len, all);}

        while (!queue.isEmpty() && len > 20) {
            int cur = queue.remove();
            ans++;
            len--;
            if (--cur >= 3) {queue.add(cur);}
        }

        if (len > 20) {return ans + len - 20 + all;}

        int n = 0;
        while (!queue.isEmpty()) {
            n += queue.remove() / 3;
        }

        return ans + Math.max(n, all);
    }
}