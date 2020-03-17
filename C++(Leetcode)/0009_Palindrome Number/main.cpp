//
//  main.cpp
//  0009_Palindrome Number
//
//  Created by 倪浩鹏 on 2020/3/17.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {return false;}
        long res = 0;
        // 设置长整型，防止有特别大的数据
        long tmp = (long)x;
        while(x){
            res *= 10;
            res += x % 10;
            x = x / 10;
        }
        return (tmp == res);
    }
};
