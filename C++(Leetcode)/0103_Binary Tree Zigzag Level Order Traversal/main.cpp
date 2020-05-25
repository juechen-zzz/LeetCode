//
//  main.cpp
//  0103_Binary Tree Zigzag Level Order Traversal
//
//  Created by 倪浩鹏 on 2020/5/25.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    二叉树Z字形遍历，先从左到右，再从右到左
    方法：用两个栈实现，队列不适合
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> output;
        if(!root) {return output;}
        stack<TreeNode*> currentLevel,nextLevel;
        currentLevel.push(root);
        bool leftToRight = true;
        
        while(!currentLevel.empty())
        {
            int len = currentLevel.size();
            vector<int> temp;
            //stack<TreeNode*> ;
            for(int i=0; i<len; ++i)
            {
                TreeNode* current = currentLevel.top();
                currentLevel.pop();
                temp.push_back(current->val);
                
                if(leftToRight)
                {
                    if(current->left)
                        nextLevel.push(current->left);
                    if(current->right)
                        nextLevel.push(current->right);
                }
                else
                {
                    if(current->right)
                        nextLevel.push(current->right);
                     if(current->left)
                        nextLevel.push(current->left);
                }
            }
            leftToRight = !leftToRight;
            swap(currentLevel,nextLevel);
            output.push_back(temp);
        }
        return output;
        
    }
};
