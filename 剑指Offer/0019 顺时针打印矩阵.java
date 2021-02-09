/* 
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {return order;}
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order.add(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                order.add(matrix[j][right]);
            }
            right--;
            if (left <= right && top <= bottom) {
                for (int i = right; i >= left; i--) {
                    order.add(matrix[bottom][i]);
                }
                bottom--;
                for (int j = bottom; j >= top; j--) {
                    order.add(matrix[j][left]);
                }
                left++;
            }
        }
        return order;
    }
}