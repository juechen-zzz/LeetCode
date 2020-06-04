//
//  main.cpp
//  0112_Path Sum
//
//  Created by 倪浩鹏 on 2020/6/4.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    判断一棵树是否存在一条路径的和为给定值
 */

#include <iostream>
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
bool hasPathSum(TreeNode *root, int sum){
    if (root == NULL) {return false;}
    if (root->val == sum && root->left == NULL && root->right == NULL) {return true;}
    sum -= root->val;
    return (hasPathSum(root->left, sum) || hasPathSum(root->right, sum));
}
