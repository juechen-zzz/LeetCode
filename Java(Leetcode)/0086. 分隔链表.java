/* 
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {return null;}
        ListNode cur1 = new ListNode(-1);
        ListNode cur2 = new ListNode(-1);
        ListNode p1 = cur1, p2 = cur2;
        while (head != null) {
            if (head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        // 注意考虑最后的结尾部分要指向null
        cur1.next = p2.next;
        cur2.next = null;
        return p1.next;
    }
}