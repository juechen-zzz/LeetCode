/* 
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmp = new ListNode(-1, head);

        ListNode pre = tmp;
        ListNode cur = head;

        int step = 0;
        while (step < m - 1) {
            pre = pre.next;
            cur = cur.next;
            step++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode a = cur.next;
            cur.next = cur.next.next;

            a.next = pre.next;
            pre.next = a;
        }
        return tmp.next;
    }
}