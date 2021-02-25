/* 
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1, head);
        ListNode cur = tmp;
        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
            }
            else {
                cur = cur.next;
            }
            head = head.next;
        }
        return tmp.next;
    }
}