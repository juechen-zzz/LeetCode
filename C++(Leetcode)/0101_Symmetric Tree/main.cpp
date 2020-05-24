//
//  main.cpp
//  0101_Symmetric Tree
//
//  Created by 倪浩鹏 on 2020/5/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3
  

 But the following [1,2,2,null,3,null,3] is not:

     1
    / \
   2   2
    \   \
    3    3
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
    bool isSymmetric(TreeNode* root) {
        return isSymmetric_(root,root);
    }
    
    bool isSymmetric_(TreeNode* r1,TreeNode* r2)
    {
        if(!r1 && !r2) return true;
        if(!r1 || !r2) return false;
       return (r1->val==r2->val) && isSymmetric_(r1->left,r2->right) && isSymmetric_(r1->right,r2->left);
    }
};
