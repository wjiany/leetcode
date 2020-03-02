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
public class ReverseKGroup_25 {

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseKGroup(node1,3);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return fun(head,k);
    }

    /**
     *k个一组逆序，不足的不逆序
     * @param head
     * @param k
     * @return
     */
    private ListNode fun(ListNode head,int k){
        ListNode indexPoint = head;
        int len = k;
        for (; len > 0 && indexPoint!=null; len--) {
            indexPoint = indexPoint.next;
        }
        if(len > 0){
            return head;
        }
        int tmp = k;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode tail =head;
        while (head!=null && --tmp>=0){
            ListNode newHead = head.next;
            ListNode curr = pre.next;
            pre.next = head;
            head.next = curr;

            head = newHead;
        }
        if(head!=null){
            tail.next = fun(head, k);
        }
        return dummy.next;
    }

    /**
     * 和题目不符合，这个是不足k的时候也反转
     * @param head
     * @param k
     * @return
     */
    private ListNode fun2(ListNode head,int k){
        int tmp = k;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode tail =head;
        while (head!=null && tmp-->0){
            ListNode newHead = head.next;
            ListNode curr = pre.next;
            pre.next = head;
            head.next = curr;

            head = newHead;
        }
        if(head!=null){
            tail.next = fun(head, k);
        }
        return dummy.next;
    }
}