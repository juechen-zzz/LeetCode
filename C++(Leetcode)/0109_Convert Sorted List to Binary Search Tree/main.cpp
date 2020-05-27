//
//  main.cpp
//  0109_Convert Sorted List to Binary Search Tree
//
//  Created by 倪浩鹏 on 2020/5/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    用排好序的链表构建BST
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
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
    TreeNode* sortedListToBST(ListNode* head) {
        vector<int> nums;
        ListNode *p = head;
        while (p) {
            nums.push_back(p->val);
            p = p->next;
        }
        TreeNode* root = sortedArrayToBST(nums);
        return root;
    }
    
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.empty()) {return NULL;}
        int mid = nums.size() / 2;
        TreeNode *root = new TreeNode(nums[mid]);
        vector<int> numsLeft(nums.begin(), nums.begin()+mid);
        root->left = sortedArrayToBST(numsLeft);
        vector<int> numsRight(nums.begin()+mid+1, nums.end());
        root->right = sortedArrayToBST(numsRight);
        return root;
    }
};


// solution 2
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(head==nullptr) return nullptr;
        ListNode *slow=head;
        ListNode *fast=head->next;
        while(fast && fast->next)           // 双指针找中位数
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        
        TreeNode *rootn=new TreeNode(slow->val);        // 构建根节点
        
        ListNode *root=slow;
        ListNode *rightl=slow->next;
        ListNode *leftl=head;
        slow=head;
        if(slow==root) leftl=nullptr;
        else
        {
            while(slow->next!=root) slow=slow->next;
            slow->next=nullptr;
         }
        
        rootn->left=sortedListToBST(leftl);
        rootn->right=sortedListToBST(rightl);
        return rootn;
    }
};
