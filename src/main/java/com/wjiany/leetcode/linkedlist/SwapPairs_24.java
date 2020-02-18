package com.wjiany.leetcode.linkedlist;

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs_24 {
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = swapPairs(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        swap(dummy);
        return dummy.next;
    }
    private void swap(ListNode dummy){
        if(dummy.next == null || dummy.next.next == null){
            return ;
        }
        ListNode curr = dummy.next;
        ListNode next = dummy.next.next;
        ListNode nextNext = next.next;

        dummy.next = next;
        next.next = curr;
        curr.next = nextNext;
        swap(curr);
    }
    /**
     * 方法一，每次交换pre 后面的两个节点
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next!=null&&pre.next.next!=null){
            ListNode curr = pre.next;
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            pre.next = next;

            pre = curr;
        }
        return dummy.next;
    }
}