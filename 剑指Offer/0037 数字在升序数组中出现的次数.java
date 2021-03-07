/* 
统计一个数字在升序数组中出现的次数。
 */

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {return 0;}
        int left = findTarget(array, k, true);
        int right = findTarget(array, k, false);

        if (right != -1 && left != -1) {return right - left + 1;}
        else {return 0;}
    }
    
    public int findTarget(int[] array, int target, boolean isLeft) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            }
            else if (array[mid] < target){
                left = mid + 1;
            }
            else {
                if (isLeft) {right = mid - 1;}
                else {left = mid + 1;}
            }
        }
        if (isLeft && (left >= array.length || array[left] != target)) {return -1;}
        if ((!isLeft) && (right < 0 || array[right] != target)) {return -1;}
        return isLeft ? left : right;
    }
}