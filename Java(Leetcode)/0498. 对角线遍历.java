/* 
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

 

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

 */

// 考虑按照对角线打印元素，先不考虑翻转
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {return new int[0];}

        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];

        int idx = 0;
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < m + n - 1; i++) {
            tmp.clear();

            int row = i < n ? 0 : i - n + 1;
            int col = i < n ? i : n - 1;

            while (row < m && col > -1) {
                tmp.add(matrix[row][col]);
                row++;
                col--;
            }

            if (i % 2 == 0) {
                Collections.reverse(tmp);
            }

            for (int j = 0; j < tmp.size(); j++) {
                ans[idx++] = tmp.get(j);
            }
        }

        return ans;
    }
}