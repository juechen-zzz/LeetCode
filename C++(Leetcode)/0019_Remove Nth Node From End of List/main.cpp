//
//  main.cpp
//  0019_Remove Nth Node From End of List
//
//  Created by 倪浩鹏 on 2020/3/23.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 删除链表倒数第n个数
 
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.
 */



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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 首先，计算链表长度，单链表无法反向遍历
        ListNode *tmp = head;
        int len = 0;
        while (tmp){
            tmp = tmp->next;
            len++;
        }
        
        // 当要删除的就是头节点的情况
        if (len == n) {
            head = head->next;
            return head;
        }
        
        // 正常遍历到要删除的节点前一个节点
        tmp = head;
        int i = 1;
        while(i < len - n){
            tmp = tmp->next;
            i++;
        }
        
        // 保存删除的节点
        ListNode* del = tmp->next;
        tmp->next = tmp->next->next;
        delete(del);
        return head;
    }
};
