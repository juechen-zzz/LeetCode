//
//  main.cpp
//  0061_Rotate List
//
//  Created by 倪浩鹏 on 2020/5/7.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 旋转链表
 先遍历单向链表并将其尾部指向 head ，将其变为单向环装列表，并记录链表元素个数 count ；
 之后根据右移次数 k ，在头部开始的第 count-k 个节点处切段链表，该节点的后一个节点就是新的头结点。
 
 Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL || head->next == NULL || k == 0)
            return head;
        
        ListNode *temp = head;
        int count = 1;
        
        //先将单链表转换为环装列表
        while(temp->next != NULL){
            temp = temp->next;
            count++; //记录链表元素个数
        }
        k = k % count; //k大于元素个数时，只需要处理余数部分
        if(k == 0)
            return head;
        temp->next = head; //将单链表连接成环状列表
        
        //根据右移次数，在对应位置切断环装链表，返回新的表头
        temp = head;
        for(int i = 1; i < (count-k); i++){
            temp = temp->next;
        }
        ListNode *res = temp->next; //定位到切段环装链表位置的前一个节点
        temp->next = NULL; //切段环装链表
        return res;
    }
};
