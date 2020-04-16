//
//  main.cpp
//  0045_Jump Game II
//
//  Created by 倪浩鹏 on 2020/4/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 跳跃数组，数组值就是当前最多可以跳的步数，问最少几步跳完
 
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

#include <iostream>

class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() <= 1) {return 0;}
        int l = 0;
        int r = nums[0];
        int times = 1;
        // 每次找到下一步能跳到的最远位置即可
        while (r < nums.size()-1){
            times++;
            int next = l + nums[l];
            for (int i = l; i <= r; i++){
                if (i + nums[i] > next){
                    next = i + nums[i];
                }
            }
            l = r;
            r = next;
        }
        return times;
    }
};
