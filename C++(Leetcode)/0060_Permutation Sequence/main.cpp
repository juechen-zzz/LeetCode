//
//  main.cpp
//  0060_Permutation Sequence
//
//  Created by 倪浩鹏 on 2020/5/4.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 输入第k个数列（排好序后）
 The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"
 */

#include <iostream>

//法一：用vector的内置函数next_permutation
class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> v;
        for(int i=1; i<=n; i++)
            v.push_back(i);
        for(int i=0; i<k-1; i++)
            next_permutation(v.begin(), v.end());
        string ans="";
        for(int i=0; i<v.size(); i++)
            ans = ans + to_string(v[i]);
        return ans;
    }
};

//法二
class Solution {
public:
    string getPermutation(int n, int k) {
        int fact[10];                   // 存放阶乘
        fact[0]=1;
        string s;                       // 输出一个"12345"
        for(int i=1;i<=n;i++){
            fact[i]=i*fact[i-1];
            s+= i+'0';                  // 通过+'0'这种方式完成类型转换
        }
        string res;
        while(n){
            int idx = k/fact[n-1];
            k%=fact[n-1];
            if(k==0){
                idx--;
                k=fact[n-1];
            }
            res += s[idx];
            s.erase(s.begin()+idx);     // 将用过的数去掉
            n--;
        }
        return res;
    }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
