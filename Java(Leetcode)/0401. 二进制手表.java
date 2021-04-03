/*
二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。

每个 LED 代表一个 0 或 1，最低位在右侧。

示例：

输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 

提示：
输出的顺序没有要求。
小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
*/

class Solution {
    List<String> ans = new ArrayList<>();
    int[] dic = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        dfs(num, 0, 0, 0);
        return ans;
    }

    private void dfs(int count, int hour, int minute, int index) {
        if (count == 0) {
            ans.add(hour + ":" + (minute > 9 ? minute : "0" + minute));
        }
        for (int i = index; i < 10; i++) {
            if (i < 4 && hour + dic[i] < 12) {
                dfs(count - 1, hour + dic[i], minute, i + 1);
            }
            if (i >= 4 && minute + dic[i] < 60) {
                dfs(count - 1, hour, minute + dic[i], i + 1);
            }
        }
    }
}