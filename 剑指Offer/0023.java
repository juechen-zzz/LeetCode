/* 
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {return false;}
        boolean ans = isBST(sequence, 0, sequence.length - 1);
        return ans;
    }
    
    public boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) {return true;}
        int cur = sequence[end];
        int splitIndex = start;
        while (splitIndex < end && sequence[splitIndex] < cur) {splitIndex++;}
        for (int i = splitIndex; i < end; i++) {
            if (sequence[i] < cur) {
                return false;
            }
        }
        return isBST(sequence, start, splitIndex - 1) && isBST(sequence, splitIndex, end - 1);
    }
}
