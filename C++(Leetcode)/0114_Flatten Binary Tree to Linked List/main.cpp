//
//  main.cpp
//  0114_Flatten Binary Tree to Linked List
//
//  Created by 倪浩鹏 on 2020/6/4.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    将二叉树展平为链表
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
    void flatten(TreeNode* root) {
        if(root == NULL)return;
        flatten(root->left);
        flatten(root->right);
        TreeNode* res=root;
        TreeNode* l=root->left;
        TreeNode* r=root->right;
        root->left=NULL;
        while(l)
        {
            res->right=l;
            l=l->right;
            res=res->right;
        }
        while(r)
        {
            res->right=r;
            r=r->right;
            res=res->right;
        }
    }
};
