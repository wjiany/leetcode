package com.leetcode.wjiany.list;

/**
 * 某段链表反转
 */
public class ReverseBetween_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode pre = head;

        for(int i = 0 ;i < m-1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode tail = cur;
        for(int i = 0 ;i < n-m+1; i++){
            ListNode temp = cur.next;
            cur.next=pre.next;
            pre.next = cur;
            cur = temp;
        }
        tail.next = cur;
        return head;
    }
}


