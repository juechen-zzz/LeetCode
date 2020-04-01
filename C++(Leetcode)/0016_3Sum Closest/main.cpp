//
//  main.cpp
//  0016_3Sum Closest
//
//  Created by 倪浩鹏 on 2020/3/20.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 三数和最接近一个值，返回这三个数的和
 
 Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

#include <iostream>
#include <vector>
using namespace std;

//void PrintVector1(vector<int> &v){
//    for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
//        cout << (*it) << " ";
//    }
//    cout << endl;
//}

int threeSumClosest(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    int ans = nums[0] + nums[1] + nums[2];
    int len = (int)nums.size();
    for (int i = 0; i < len - 2; i++) {
        int l = i + 1;
        int r = len - 1;
        while (l < r) {
            int total = nums[i] + nums[l] + nums[r];
            if (abs((int)(total - target)) < abs((int)(ans - target))) {ans = total;}
            
            if (total < target) {l++;}
            else if (total > target) {r--;}
            else {
                ans = target;
                break;
            }
        }
    }
    return ans;
}

int main(int argc, const char * argv[]) {
    int s[] = {0, 2, 1, -3};
    vector<int> ss(s, s + 4);
    cout << threeSumClosest(ss, 1) << endl;
    cout << abs(-2);
    return 0;
}
