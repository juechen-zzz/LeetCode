//
//  main.cpp
//  0125_Valid Palindrome
//
//  Created by 倪浩鹏 on 2020/6/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    判断字符串是否回文
 */

class Solution {
public:
    bool isPalindrome(string s) {
        int l = 0, r = s.length()-1, index =0;
        while(l < r) {
            //  void isalnum(int c) 检查所传的字符是否是字母和数字
            if(!isalnum(s[l])) {
                l++;
                continue;
            }
            if(!isalnum(s[r])) {
                r--;
                continue;
            }
            if(65<=s[l] && s[l] <=90)       // 小写转大写
              s[l]=s[l]+32;
            if(65<=s[r] && s[r] <=90)
              s[r]=s[r]+32;
            if(s[l]!=s[r])
              return false;
            r--;
            l++;
        }
        return true;
    }
};
