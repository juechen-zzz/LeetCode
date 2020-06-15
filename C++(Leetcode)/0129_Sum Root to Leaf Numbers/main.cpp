//
//  main.cpp
//  0129_Sum Root to Leaf Numbers
//
//  Created by 倪浩鹏 on 2020/6/15.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    二叉树所有从跟到叶构成的整数求和
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
    int sumNumbers_(TreeNode* root, int res) {

        if (root->left == nullptr && root->right == nullptr) {return res * 10 + root->val;}

        int left = 0, right = 0;

        if (root->left) {left = sumNumbers_(root->left, res * 10 + root->val);}
        if (root->right) {right = sumNumbers_(root->right, res * 10 + root->val);}

        return left + right;
    }

    int sumNumbers(TreeNode* root) {
        if (root == nullptr) return 0;
        return sumNumbers_(root, 0);
    }
};
