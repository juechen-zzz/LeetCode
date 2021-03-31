/**
 * @description:
 *     给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 *     将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *     假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     输出：7 -> 0 -> 8
 *     原因：342 + 465 = 807
 *
 * 时间复杂度：O(max(m,n))    m,n对应两个链表的长度
 * 空间复杂度：O(max(m,n))
 */

public class LeetCode0002 {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个carry来记录和超过10的情况，其余正常相加保存即可
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }

        return head.next;
    }
}
