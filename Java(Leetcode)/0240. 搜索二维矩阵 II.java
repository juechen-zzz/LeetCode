/* 
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 ) {return false;}

        int left = 0;
        int right = matrix[0].length - 1;

        while (left < matrix.length && right >= 0){
            if(matrix[left][right] == target) {
                return true;
            }
            else if (matrix[left][right] > target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
}