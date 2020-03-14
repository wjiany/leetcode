package com.wjiany.leetcode.linkedlist;

import org.junit.Test;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateRight_61 {

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
        ListNode node = rotateRight(node1, 6);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 效率低
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode secondPre = dummy;
        ListNode firstPre = dummy;
        while (k-->0){
            firstPre = firstPre.next;
            if(firstPre == null){
                firstPre = head;
            }
        }
        while (firstPre.next != null){
            firstPre = firstPre.next;
            secondPre = secondPre.next;
        }
        ListNode second = secondPre.next;
        secondPre.next = null;

        ListNode headFitst = dummy.next;
        dummy.next = second;
        firstPre.next = headFitst;
        return dummy.next;
    }

    /**
     * 官方
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight_offical(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}