//
//  main.cpp
//  0055_Jump Game
//
//  Created by 倪浩鹏 on 2020/4/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 跳跃游戏
 
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
              jump length is 0, which makes it impossible to reach the last index.
 */

#include <iostream>
#include <vector>
using namespace std;

void PrintVector(vector<int> &v){
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
        cout << (*it) << " ";
    }
    cout << endl;
}

bool canJump(vector<int>& nums) {
    int N = (int)nums.size();
    if (N == 1) {return true;}
    for (int i = 0; i < N; i++){
        if (nums[i] == 0 && i != N-1){
            int cur = i - 1;
            // 判定是否在为0处可以从前面的点跳过去，不行就往前继续检查，如果检查到第一个元素也不行，则return false
            while (cur >= 0 && nums[cur] <= i-cur) {cur--;}
            if (cur == -1) {return false;}
        }
    }
    return true;
}

int main(int argc, const char * argv[]) {
    int a[] = {2, 3, 1, 1, 4};
    vector<int> nums(a, a+5);
    PrintVector(nums);
    cout << canJump(nums) << endl;
    return 0;
}
