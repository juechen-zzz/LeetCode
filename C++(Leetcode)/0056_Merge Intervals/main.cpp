//
//  main.cpp
//  0056_Merge Intervals
//
//  Created by 倪浩鹏 on 2020/4/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

#include <iostream>

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& interval) {
        vector<vector<int>> ans;
        if(interval.size()==0)return ans;
        sort(interval.begin(),interval.end());
        ans.push_back(interval[0]);
        int j=0;
        for(int i=1;i<interval.size();i++)
        {
            if(ans[j][1]>=interval[i][0])
                ans[j][1]=max(ans[j][1],interval[i][1]);
            else
            {
                j++;
                ans.push_back(interval[i]);
            }
        }
        return ans;
    }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
