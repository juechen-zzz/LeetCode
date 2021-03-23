/* 
我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。

每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。



示例 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

返回 true。5个矩形一起可以精确地覆盖一个矩形区域。

 */

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        // 完美矩形的左下角和右上角坐标
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        // 小矩形面积之和
        int areas = 0;
        // 记录所有顶点的出现情况
        Set<String> set = new HashSet<>();
        for (int[] tmp : rectangles) {
            int x1 = tmp[0], y1 = tmp[1], x2 = tmp[2], y2 = tmp[3];

            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            areas += (x2 - x1) * (y2 - y1);

            String[] curPoints = {x1 + " " + y1, x2 + " " + y2, x1 + " " + y2, x2 + " " + y1};
            for (String s : curPoints) {
                if (set.contains(s)) {set.remove(s);}
                else {set.add(s);}
            }
        }

        // 面积是否相等
        if (areas != (X2 - X1) * (Y2 - Y1)) {return false;}

        // 顶点情况是否满足
        if (set.size() != 4 || !set.contains(X1 + " " + Y1) || !set.contains(X2 + " " + Y2)
            || !set.contains(X1 + " " + Y2) || !set.contains(X2 + " " + Y1)) {
                return false;
            }
        return true;
    }
}
