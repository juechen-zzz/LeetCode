//
//  main.cpp
//  0100_Same Tree
//
//  Created by 倪浩鹏 on 2020/5/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 判断是否为同一棵树
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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p==NULL && q==NULL){
            return true;
        }
        if((p &&!q) || (!p && q)){
            return false;
        }
        if(p->val!=q->val){
            return false;
        }
        bool leftcheck=isSameTree(p->left,q->left);
        bool rightcheck=isSameTree(p->right,q->right);
        
        if(leftcheck && rightcheck){
            return true;
        }else{
            return false;
        }
    }
};
