/* 
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：
给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(-1, head);

        ListNode pre = ans;
        ListNode end = ans;

        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {end = end.next;}
            if (end == null) {break;}
            ListNode start = pre.next;
            ListNode nxt = end.next;

            end.next = null;
            pre.next = myReverse(start);
            start.next = nxt;

            pre = start;
            end = start;
        }

        return ans.next;
    }

    public ListNode myReverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }
}