//
//  main.cpp
//  0024_Swap Nodes in Pairs
//
//  Created by 倪浩鹏 on 2020/3/25.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 You may not modify the values in the list's nodes, only nodes itself may be changed.

  

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 
 这个题的难点在于，一个链表例如1->2->3->4，如果两两分组，执行12交换、34交换这样的步骤，12交换后工作并没有完成，1后面应该链接的是交换后的4，3后面连接的也应该是交换后的链表。
 */


// 回溯
ListNode * swapPairs(ListNode * head) {         // 节点顺序1-2-3
    if (head==NULL || head->next==NULL) return head;
    
    ListNode *tmp = head->next;                 // tmp为2
    
    head->next = swapPairs(tmp->next);          // 回溯   1-swapPairs(3)
    
    tmp->next = head;                           // 2-1
    return tmp;
}

// 将需要交换的两个节点的前一个节点也看做这一组的内容，每次调整三个节点的关系，这样也能解决如果是单数个节点最后一个不用调整的问题。
ListNode* swapPairs(ListNode* head) {
    ListNode* res=new ListNode(0);
    res->next = head;
    ListNode* a = res;
    
    while (a->next!=NULL && a->next->next!=NULL)        // 节点顺序0-1-2-3
    {
         ListNode* b = a->next->next;                   // b为2
         a->next->next = b->next;                       // 1-3
         b->next = a->next;                             // 2-1
         a->next = b;                                   // 0-2
         a = b->next;                                   // a为1
    }                                                   // 0-2-1-3
    return res->next;
}
