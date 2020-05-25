//
//  main.cpp
//  0106_Construct Binary Tree from Inorder and Postorder Traversal
//
//  Created by 倪浩鹏 on 2020/5/26.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    ￥给定中序和后序，构建二叉树
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
    int search(int val, vector<int>&target, int start, int end){
        vector<int>::iterator iter = find(target.begin() + start, target.begin() + end, val);
        return distance(target.begin(), iter);
    }

    TreeNode* buildTreeHelper(vector<int>& inorder, vector<int>& postorder, int &post_start, int in_start, int in_end){
        if(in_start > in_end){return NULL;}
        int val = postorder[post_start];
        TreeNode* node = new TreeNode(val);

        int root_index = search(val, inorder, in_start, in_end);
        post_start--;
        node->right = buildTreeHelper(inorder, postorder, post_start, root_index + 1, in_end);
        node->left = buildTreeHelper(inorder, postorder, post_start, in_start, root_index - 1);
        return node;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.size() !=  inorder.size()){return NULL;}
        int start = postorder.size() - 1;
        return buildTreeHelper(inorder, postorder, start, 0, inorder.size() - 1);
    }
};
