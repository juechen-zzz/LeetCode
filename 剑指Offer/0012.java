/* 
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
 */

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {return 1;}
        else if (exponent > 0) {
            double num = base;
            for (int i = 1; i < exponent; i++) {
                num *= base;
            }
            return num;
        }
        else {
            double num = base;
            exponent = -exponent;
            for (int i = 1; i < exponent; i++) {
                num *= base;
            }
            return 1 / num;
        }
  }
}