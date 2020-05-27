//
//  main.cpp
//  0108_Convert Sorted Array to Binary Search Tree
//
//  Created by 倪浩鹏 on 2020/5/27.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    将排列好数组转换为二叉搜索树
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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.empty()) {return NULL;}
        int mid = nums.size() / 2;
        TreeNode *root = new TreeNode(nums[mid]);
        vector<int> numsLeft(nums.begin(), nums.begin()+mid);
        root->left = sortedArrayToBST(numsLeft);
        vector<int> numsRight(nums.begin()+mid+1, nums.end());
        root->right = sortedArrayToBST(numsRight);
        return root;
    }
};
