//
//  main.cpp
//  0105_Construct Binary Tree from Preorder and Inorder Traversal
//
//  Created by 倪浩鹏 on 2020/5/25.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    ￥给先序和中序，构建二叉树
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
int SearchVal(vector <int> &vec, int val ,int s,  int e){
    auto itr = find(vec.begin() + s, vec.begin() + e, val);
    return itr - vec.begin();
}

int pre_idx;
unordered_map <int,int> hsh_map;

TreeNode * BuildTreeUtil(vector<int> & preorder,vector<int> &inorder , int in_start, int in_end){
    if(in_start > in_end){return NULL;}
    int val = preorder[pre_idx++];
    TreeNode * node = new TreeNode(val);
    //    int in_mid = SearchVal(inorder,val , in_start, in_end);
    int in_mid = hsh_map[val];
    node->left = BuildTreeUtil(preorder, inorder, in_start, in_mid-1);
    node->right= BuildTreeUtil(preorder, inorder, in_mid +1, in_end);
    return node;
}

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        pre_idx=0;
        hsh_map.clear();
        for(int i = 0 ; i < preorder.size() ; i++)
            hsh_map[inorder[i]] = i;
        return BuildTreeUtil(preorder, inorder, 0, inorder.size()-1);
    }
};
