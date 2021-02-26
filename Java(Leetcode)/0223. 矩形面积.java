/* 
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

每个矩形由其左下顶点和右上顶点坐标表示，如图所示。

示例:

输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45

 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 左下角
        int leftBotX = Math.max(A, E);
        int leftBotY = Math.max(B, F);

        // 右上角
        int rightTopX = Math.min(C, G);
        int rightTopY = Math.min(D, H);

        int total = (C - A) * (D - B) + (G - E) * (H - F);

        // 无重叠
        if (C <= E || H <= B || G <= A || D <= F) {
            return total;
        }

        return total - (rightTopX - leftBotX) * (rightTopY - leftBotY);
    }
}