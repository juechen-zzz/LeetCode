/* 
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Stack;
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0) {return;}
        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for(int i = 0;i<array.length;i++){
            if(array[i] & 1 == 1) {
                odd.push(array[i]);
            }
            else {
                even.push(array[i]);
            }
        }
        int index = array.length - 1;
        while(!even.isEmpty()){array[index--] = even.pop();}
        while(!odd.isEmpty()) {array[index--] = odd.pop();}
    }
}