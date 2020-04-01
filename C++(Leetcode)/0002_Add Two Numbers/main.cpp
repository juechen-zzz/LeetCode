//
//  main.cpp
//  0002_Add Two Numbers
//
//  Created by 倪浩鹏 on 2020/3/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 将两个表示数字链表相加
 
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
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
    ListNode* addTwoNumbers(ListNode *l1, ListNode *l2) {
        // 定义答案指针和前向指针
        ListNode *ans=NULL;
        ListNode *prev=NULL;
        bool carry=0;
        int sum;
        while(l1!=NULL || l2!=NULL){
            // 当前l1若存在，返回l1->val，否则返回0，同时带上前一位有可能的进位1
            sum=carry+(l1?l1->val:0)+(l2?l2->val:0);
            // 判定sum是否大于10，大于等于则为1，小于为0（就是先将对应位相加，若大于10，再进行别的操作）
            carry=(sum>=10)?1:0;
            sum=sum%10;
            // 定义临时指针，存放对应位相加后的、对10求过余的值
            ListNode* temp=new ListNode(sum);
            if(not ans){
                ans=temp;
                prev=ans;
            }else{
                prev->next=temp;
                prev=prev->next;
            }
            // 向后遍历
            if(l1){
                l1=l1->next;
            }
            if(l2){
                l2=l2->next;
            }
        }
        // 当最高位相加也需要进位时，再多创建一个节点接到最后
        if(carry){
            prev->next=new ListNode(carry);
        }
        return ans;
    }
};
