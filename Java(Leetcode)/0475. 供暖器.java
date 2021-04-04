/* 
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

在加热器的加热半径范围内的每个房屋都可以获得供暖。

现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。

说明：所有供暖器都遵循你的半径标准，加热的半径也一样。

 

示例 1:

输入: houses = [1,2,3], heaters = [2]
输出: 1
解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
示例 2:

输入: houses = [1,2,3,4], heaters = [1,4]
输出: 1
解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
示例 3：

输入：houses = [1,5], heaters = [2]
输出：3

 */

class Solution {
    // 双指针
    public int findRadius(int[] houses, int[] heaters) {
        // 1. 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 2. 双指针计算最大半径
        // 下面的代码最难懂的地方是 Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)
        // 我们举一个例子来说明这行代码的意思：
        // houses：1，2，3，4
        // heaters：1，4
        // 对于 house 1，heater 1 比 heater 4 更接近 house1，所以不将 i 移动到 i + 1
        // 对于 house 2，heater 1 比 heater 4 更接近 house2，所以不将 i 移动到 i + 1
        // 对于 house 3，heater 4 比 heater 1 更接近 house3，所以将 i 移动到 i + 1
        // 对于 house 4，依次类推
        int ans = 0, idx = 0;
        for (int h : houses) {
            while (idx < heaters.length - 1 && Math.abs(heaters[idx] - h) >= Math.abs(heaters[idx + 1] - h)) {
                idx++;
            }
            ans = Math.max(ans, Math.abs(heaters[idx] - h));
        }

        return ans;
    }
}
