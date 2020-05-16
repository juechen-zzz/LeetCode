//
//  main.cpp
//  0085_Partition List_
//
//  Created by 倪浩鹏 on 2020/5/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 分隔链表
 
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Example:

 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5
 */

// solution 1 双指针
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
    ListNode* partition(ListNode* head, int x) {
        ListNode *p = new ListNode(-1);
        ListNode *c = new ListNode(-1);
        ListNode *p_h = p;
        ListNode *c_h = c;
        ListNode *tmp = head;
        while (tmp){
            if (tmp->val < x) {
                p->next = tmp;
                p = p->next;
            } else {
                c->next = tmp;
                c = c->next;
            }
            tmp = tmp->next;
        }
        p->next = c_h->next;
        c->next = NULL;
        return p_h->next;
    }
};
