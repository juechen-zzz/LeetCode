//
//  main.cpp
//  0104_Maximum Depth of Binary Tree
//
//  Created by 倪浩鹏 on 2020/5/25.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    二叉树最大深度
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
    int maxDepth(TreeNode* root) {
        if (root == NULL) return 0;
        return max(maxDepth(root->right), maxDepth(root->left)) + 1;
    }
};
