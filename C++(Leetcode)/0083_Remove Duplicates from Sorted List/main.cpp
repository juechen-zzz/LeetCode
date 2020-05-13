//
//  main.cpp
//  0083_Remove Duplicates from Sorted List
//
//  Created by 倪浩鹏 on 2020/5/13.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 删除链表重复元素，留一个
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
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == NULL || head->next == NULL){return head;}
        ListNode *pre = new ListNode();
        ListNode *cur = head;
        while (cur) {
            pre = cur;
            cur = cur->next;
            while (cur && pre->val == cur->val){
                pre->next = cur->next;
                cur = cur->next;
            }
        }
        return head;
    }
};
