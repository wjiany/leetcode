package com.leetcode.wjiany.linkedlist;

/**
 * 删除链表倒数第N个元素
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode point = dummy;
        while (n>=0){
            n--;
            point = point.next;
        }
        while (point!=null){
            pre = pre.next;
            point = point.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
