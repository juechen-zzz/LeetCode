//
//  main.cpp
//  0070_Climbing Stairs
//
//  Created by 倪浩鹏 on 2020/5/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 单步跳跃总数
 
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 */

class Solution {
public:
    int climbStairs(int n) {
        if (n < 1) {return 0;}
        if (n == 1){return 1;}
        if (n == 2){return 2;}
        int arr[n+1];
        arr[1] = 1;
        arr[2] = 2;
        int index = 3;
        while (index <= n){
            arr[index++] = arr[index-1] + arr[index-2];
        }
        return arr[n];
    }
};
