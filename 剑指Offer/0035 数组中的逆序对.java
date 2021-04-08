/* 
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
即输出P%1000000007

 */

public class Solution {
    public int InversePairs(int [] array) {
        return (int)(mergesort(array, 0 , array.length-1)%1000000007);
    }
    public static long mymerge(int [] array, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int index = right-left;
        long countnum = 0;
        int i = mid;
        int j = right;
        while(i >= left && j >= mid+1){
            if(array[i] > array[j]){
                countnum += (j-mid);
                temp[index--] = array[i--];
            }
            else{
                temp[index--] = array[j--];
            }
        }
        while(i >= left)
            temp[index--] = array[i--];
        while(j >= mid+1)
            temp[index--] = array[j--];
        for(i = 0; i < temp.length; ++i)
            array[i+left] = temp[i];
        return countnum;
    }
    public static long mergesort(int [] array, int left, int right){
        if(left >= right)
            return 0;
        int mid = (left + right) / 2;
        long leftCount = mergesort(array, left, mid);
        long rightCount = mergesort(array, mid+1, right);
        long res = mymerge(array, left, mid, right);
        return res + leftCount + rightCount;
    }
}