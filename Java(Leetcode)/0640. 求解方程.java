/* 
求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。

如果方程没有解，请返回“No solution”。

如果方程有无限解，则返回“Infinite solutions”。

如果方程中只有一个解，要保证返回值 x 是一个整数。

示例 1：

输入: "x+5-3+x=6+x-2"
输出: "x=2"
示例 2:

输入: "x=x"
输出: "Infinite solutions"
示例 3:

输入: "2x=x"
输出: "x=0"
示例 4:

输入: "2x+3x-6x=x+2"
输出: "x=-1"
示例 5:

输入: "x=x+2"
输出: "No solution"

 */

class Solution {
    public String solveEquation(String equation) {
        String ans = null;
        try {
            String[] split = equation.split("=");
            String left = split[0], right = split[1];
            int[] leftAns = splitVar(left);
            int[] rightAns = splitVar(right);
            
            int xNum = leftAns[0] - rightAns[0];
            int constNum = rightAns[1] - leftAns[1];
            if (xNum != 0) {return "x=" + constNum / xNum;}
            if (constNum == 0) {return "Infinite solutions";}

            return "No solution";
        } catch (Exception e) {ans = "No solution";}
        return ans;
    }

    private static int[] splitVar(String s) {
        String[] split = s.replace("-", "+-").split("\\+");
        int sumX = 0;
        int sumS = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("x")) {
                sumX++;
            } else if (split[i].equals("-x")) {
                sumX--;
            } else if (split[i].contains("x")) {
                sumX += Integer.valueOf(split[i].substring(0, split[i].length() - 1));
            } else if (!split[i].equals("")) {
                sumS += Integer.valueOf(split[i]);
            } else {
                continue;
            }
        }
        return new int[]{sumX, sumS};
    }
}
