/* 
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 

示例 1：

输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：

输入：timePoints = ["00:00","23:59","00:00"]
输出：0

 */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) {return 0;}

        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            array[i] = minute(timePoints.get(i));
        }

        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i] - array[i - 1]);
            if (min == 0) {return 0;}
        }

        return Math.min(min, 1440 + array[0] - array[array.length - 1]);
    }

    private int minute(String s) {
        return s.charAt(0) * 600 + s.charAt(1) * 60 + s.charAt(3) * 10 + s.charAt(4);
    }
}