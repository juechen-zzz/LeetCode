//
//  main.cpp
//  0094_Binary Tree Inorder Traversal
//
//  Created by 倪浩鹏 on 2020/5/21.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 二叉树中序遍历
 
 Given a binary tree, return the inorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
    1
     \
      2
     /
    3

 Output: [1,3,2]
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        TreeNode *T = root;
        stack<TreeNode*> s;
        while (T || !s.empty()){
            while (T) {
                s.push(T);
                T = T->left;
            }
            if (!s.empty()){
                T = s.top();
                ans.push_back(T->val);
                s.pop();
                T = T->right;
            }
        }
        return ans;
    }
};
