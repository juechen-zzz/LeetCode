//
//  main.cpp
//  0084_Largest Rectangle in Histogram
//
//  Created by 倪浩鹏 on 2020/5/15.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 直方图中的最大矩形面积
 
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 
 示例的过程如下：stack<int> st
 矩阵1，高度为2，入栈，栈中元素为 0
 矩阵2，高度为1，弹出栈顶元素并计算当前最大面积，弹出后栈为空，当前元素索引为1，故长度为1，面积为1*2=2，当前元素入栈，栈中元素为 1
 矩阵3，高度为5，直接入栈，栈中元素为 1,2
 矩阵4，高度为6，直接入栈，栈中元素为1,2,3
 矩阵5，高度为2，小于栈顶元素对应矩阵高度，弹出栈顶元素3，栈非空，栈顶元素为2，故以矩阵4为最低高度的面积最大为6*(4-2-1)=6，栈中元素为1,2。此时当前矩阵高度依然小于栈顶元素对应矩阵高度，继续弹出2，栈非空，栈顶元素为1，故长度为4-1-1=2，面积为2*5=10。入栈，栈中元素为1,4
 矩阵6，高度为3,大于栈顶元素，入栈，栈中元素为1,4,5
 此时元素遍历完，弹出栈中元素。
 弹出栈顶元素5，此时栈顶元素为4，此时长度为6-4-1=1，面积为1*3=3
 弹出栈顶元素4，此时栈顶元素为1，此时长度为6-1-1=4，面积为4*2=8
 弹出栈顶元素1，此时栈为空，此时长度为6，面积为1*6=6
 注意：元素遍历完之后，栈顶元素对应的高度是小于等于其后所有矩阵的高度的，所以计算长度的时候要以矩阵个数来计算。
 */

// 原始解法，在最后一组时，要单独写，因为n的时候heights中实际无值
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size();
        stack<int> index;
        int area=0;
        for(int i=0;i<heights.size();i++){
            if(index.empty()||heights[index.top()]<heights[i]) index.push(i);
            else{
                while(!index.empty()&&heights[index.top()]>=heights[i]){
                    int tmp=index.top();
                    index.pop();
                    int length=0;
                    if(index.empty()) length=i;
                    else length=i-index.top()-1;
                    area=max(area,length*heights[tmp]);
                }
                index.push(i);
            }
        }
        while(!index.empty()){
            int tmp=index.top();
            index.pop();
            int length=0;
            if(index.empty()) length=n;
            else length=n-index.top()-1;
            area=max(area,length*heights[tmp]);
        }
        return area;
    }
};

// solution 2 改进，在求完数组大小后，再往数组中添加一个0，这样防止访问越界
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        heights.push_back(0);
        stack<int> index;
        int area = 0;
        for (int i = 0; i <= n; i++){
            if (index.empty() || heights[index.top()] < heights[i]) {index.push(i);}
            else {
                while (!index.empty() && heights[index.top()] >= heights[i]){
                    int tmp = index.top();
                    index.pop();
                    int length = 0;
                    if (index.empty()) {length = i;}
                    else {length = i - index.top() - 1;}
                    area = max(area, length*heights[tmp]);
                }
                index.push(i);
            }
        }
        return area;
    }
};

