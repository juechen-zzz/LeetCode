//
//  main.cpp
//  0107_Binary Tree Level Order Traversal II
//
//  Created by 倪浩鹏 on 2020/5/27.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    二叉树层序遍历，反向存储
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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> ans;
        if (root == NULL) {return ans;}
        TreeNode *T;
        queue<TreeNode*> Q;
        Q.push(root);
        while (!Q.empty()){
            vector<int> temp;
            int n = Q.size();
            while (n > 0){
                T = Q.front();
                temp.push_back(T->val);
                if (T->left) {Q.push(T->left);}
                if (T->right) {Q.push(T->right);}
                Q.pop();
                n--;
            }
            ans.push_back(temp);
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
