/* 
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
示例1

输入
7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]

返回值
true
 */

public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;
        
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] > target) {
                row--;
            }
            else if (array[row][col] < target) {
                col++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}