/* 
输入一个链表，输出该链表中倒数第k个结点。
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
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {return null;}
        
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < k; i++) {
            if (first.next == null) {return null;}
            first = first.next;
        }
        
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}