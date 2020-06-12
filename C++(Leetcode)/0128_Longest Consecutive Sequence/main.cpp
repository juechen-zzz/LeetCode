//
//  main.cpp
//  0128_Longest Consecutive Sequence
//
//  Created by 倪浩鹏 on 2020/6/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    数组中存在的最长连续序列长度
 */

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.size() <= 0) {return 0;}
        sort(nums.begin(), nums.end());
        int l = 1;
        int c = 1;
        for (int i = 1; i < nums.size(); i++){
            if (nums[i] != nums[i-1]){
                if (nums[i] == nums[i-1]+1) {
                    c++;
                }
                else {
                    l = max(l, c);
                    c = 1;
                }
            }
        }
        return max(l, c);
    }
};
