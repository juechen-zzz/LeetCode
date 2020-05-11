//
//  main.cpp
//  0075_Sort Colors
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 原地排序
 */

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int i = 0, red = 0, blue = nums.size() - 1;
        while(i <= blue)
        {
            if(nums[i] == 0) swap(nums[i++], nums[red++]);
            else if(nums[i] == 1) i++;
            else swap(nums[i], nums[blue--]);
        }
    }
};
