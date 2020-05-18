//
//  main.cpp
//  0092_Reverse Linked List II
//
//  Created by 倪浩鹏 on 2020/5/18.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 指定区间的链表反转
 
 Reverse a linked list from position m to n. Do it in one-pass.

 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:

 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL
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

// solution 1
class Solution {
private:
    ListNode* nextNode(ListNode* head, int m)
    {
        if (m < 0) return nullptr;
        for (; m-- && head; head = head->next)
            ;
        return head;
    }

    ListNode* reverseList(ListNode* head, int n) {
        if (n < 2) return head;
        auto *next = head;
        auto *tail = head;
        for (; n && next; --n)
        {
            auto *const tmp = next->next;
            next->next = head;
            head = next;
            next = tmp;
        }
        if (tail) tail->next = next;
        return head;
    }
    
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (auto *node = nextNode(head, m - 2)){
            node->next = reverseList(node->next, n - m + 1);
            return head;
        }
        return reverseList(head, n);
    }
};

// solution 2 多指针操作，找到区间在反转
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(!head || !head->next) return head;
        ListNode *temp,*curr,*prev=NULL,*first,*last;
        temp = head;
        int loop = n-m+1;
        if(loop==0) return head;
        
        if(m==1) first = NULL;
        else{
            m--;
            while(--m>0){
                temp = temp->next;
            }
            first = temp;
            temp = temp->next;
            first->next = NULL;
        }
        //reverse the list from index m to n
        while(loop--){
            if(!prev) last = temp;
            curr = temp->next;
            temp->next = prev;
            prev = temp;
            temp = curr;
        }
        //connect prev to first and last to temp
        if(!first) {head=prev;}
        else {first->next = prev;}
        last->next = temp;
        return head;
    }
};
