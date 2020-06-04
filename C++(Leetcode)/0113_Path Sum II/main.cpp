//
//  main.cpp
//  0113_Path Sum II
//
//  Created by 倪浩鹏 on 2020/6/4.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 将所有路径和为给定值的路径返回给一个容器
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> ans;
        vector<int> v;
        fun1(root, 0, sum, v, ans);
        return ans;
    }
    
    void fun1(TreeNode *root, int sum, int target, vector<int> &v, vector<vector<int>> &ans){
        if (root == NULL) {return;}
        sum += root->val;
        v.push_back(root->val);
        if (sum == target && root->left == NULL && root->right == NULL){
            ans.push_back(v);
        }
        fun1(root->left, sum, target, v, ans);
        fun1(root->right, sum, target, v, ans);
        v.pop_back();
    }
};

