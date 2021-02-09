/* 
输入两个链表，找出它们的第一个公共结点。
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int d1 = 0, d2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null){
            p1 = p1.next;
            d1++;
        }
        while(p2 != null){
            p2 = p2.next;
            d2++;
        }
        
        if(d1 < d2){
            int d = d2 - d1;
            while(d-- != 0){
                pHead2 = pHead2.next;
            }
        }
        else{
            int d = d1 - d2;
            while(d-- != 0){
                pHead1 = pHead1.next;
            }
        }
        
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}

