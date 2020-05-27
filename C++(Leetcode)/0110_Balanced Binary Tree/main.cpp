//
//  main.cpp
//  0110_Balanced Binary Tree
//
//  Created by 倪浩鹏 on 2020/5/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    判断是否为平衡二叉树
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
    int solve(TreeNode *root,bool &ans){
        if(root==NULL){return -1;}
        if(root->left==NULL and root->right==NULL){return 0;}
        int l=1+solve(root->left,ans);
        int r=1+solve(root->right,ans);
        if(abs(l-r)>1) ans=false;
        return max(l,r);
    }

    bool isBalanced(TreeNode* root) {
        if(root==NULL || root->left==NULL and root->right==NULL){return true;}
        bool ans=true;
        solve(root,ans);
        return ans;
    }
};
