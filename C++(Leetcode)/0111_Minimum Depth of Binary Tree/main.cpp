//
//  main.cpp
//  0111_Minimum Depth of Binary Tree
//
//  Created by 倪浩鹏 on 2020/5/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    二叉树最小深度
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
    int min = INT_MAX;
public:
    int minDepth(TreeNode* root, int level=1) {
        if (!root) return 0;
        if (!root->left && !root->right) {
            min = std::min(level,min);
        }
        minDepth(root->left, level+1);
        minDepth(root->right, level+1);
        return min;
    }
};
