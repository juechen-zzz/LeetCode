//
//  main.cpp
//  0082_Remove Duplicates from Sorted List II
//
//  Created by 倪浩鹏 on 2020/5/13.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 删除链表的重复元素，全删
 
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Return the linked list sorted as well.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
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

// 1 回溯
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL){return head;}
        // 出现相邻值相同时，循环直到出现不同值
        if(head!=NULL && head->next!=NULL && head->val==head->next->val){
            while(head!=NULL && head->next!=NULL && head->val==head->next->val){head=head->next;}
            return deleteDuplicates(head->next);
        }
        head->next = deleteDuplicates(head->next);
        return head;
    }
};

// 2 双指针
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL){return head;}
        // 由于可能前两个元素相同，所以必须要创建一个锚点
        ListNode *h = new ListNode(-1);
        h->next = head;
        ListNode *pre = h;
        ListNode *cur = head;
        while (cur){
            bool duplicate = false;
            while (cur->next && cur->val == cur->next->val){
                cur = cur->next;
                duplicate = true;
            }
            if (duplicate) {pre->next = cur->next;}
            else {pre = cur;}
            cur = cur->next;
        }
        return h->next;
    }
};
