/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
*/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {return false;}
        int num = 0, org_num = x;
        while (x > 0){
            int tmp = x % 10;
            x = x / 10;
            num = num * 10 + tmp;
        }
        return org_num == num;
    }
}