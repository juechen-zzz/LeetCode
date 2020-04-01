//
//  main.cpp
//  0021_Merge Two Sorted Lists
//
//  Created by 倪浩鹏 on 2020/3/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 混合两个链表
 
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */

#include <iostream>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        // 定义一个头结点，也用作哨兵节点
        ListNode *tmp = new ListNode(-1);
        ListNode *p = tmp;
        
        while(l1 && l2){
            if (l1->val <= l2->val){
                p->next = l1;
                l1 = l1->next;
            }
            else {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }
        
        if (l1){
            p->next = l1;
        }
        if (l2){
            p->next = l2;
        }
        return tmp->next;
    }
};
