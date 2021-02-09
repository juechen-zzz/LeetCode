/* 
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            }
            else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if (list1 != null) {tmp.next = list1;}
        else if (list2 != null) {tmp.next = list2;}
        return ans.next;
    }
}