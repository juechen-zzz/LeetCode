//
//  main.cpp
//  0011_Container With Most Water
//
//  Created by 倪浩鹏 on 2020/3/19.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */

#include <iostream>
#include <vector>
using namespace std;

int maxArea(vector<int>& height) {
    int ans = 0;
    int m_right = (int)height.size() - 1;
    int m_left = 0;
    while (m_right > m_left) {
        // 在线处理，先将左右较小的值乘上区间长度，然后和当前最大比较
        // 第二步对左右两个值中较小的值舍弃，索引向中间靠近
        ans = max(ans, min(height[m_left], height[m_right]) * (m_right - m_left));
        if (height[m_right] > height[m_left]){
            m_left += 1;
        }
        else {
            m_right -= 1;
        }
    }
    return ans;
}

void PrintVector(vector<int> &v){
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
        cout << (*it) << " ";
    }
    cout << endl;
}

int main(int argc, const char * argv[]) {
    int a[] = {1,8,6,2,5,4,8,3,7};
    vector<int> height(a, a+9);
    PrintVector(height);
    cout << "最大面积为：" << maxArea(height) << endl;
    return 0;
}
