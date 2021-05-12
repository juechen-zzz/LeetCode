/* 
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Solution {
    public int Add(int num1,int num2) {
        if(num1 == 0) {return num2;}
        if(num2 == 0) {return num1;}
        int carry;
        while(num2 != 0){
            carry = (num1 & num2) << 1;
            num1 = num1 ^ num2;
            num2 = carry;
        }
        return num1;
    }
}
