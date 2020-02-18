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
public class MergeTwoLists_21 {

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node11 = new ListNode(11);
        ListNode node21 = new ListNode(21);
        ListNode node31 = new ListNode(31);
        ListNode node41 = new ListNode(41);
        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        ListNode node = mergeTwoLists(node1, node11);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                ListNode l1Next = l1.next;
                pre.next = l1;
                l1 = l1Next;
            }else {
                ListNode l2Next = l2.next;
                pre.next = l2;
                l2 = l2Next;
            }
            pre = pre.next;
        }
        pre.next=l1==null?l2:l1;
        return dummy.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    /*
   超出内存限制
    */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        int firstTimes = 0;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        ListNode head = new ListNode(0);
        while (l1Curr.next !=null&&l2Curr.next!=null){

            firstTimes++;
            if(l1Curr.val < l2Curr.val ){
                if(firstTimes == 1){
                    head = l1Curr;
                }
                ListNode l1Next = l1Curr.next;
                if(l1Next!=null && l1Next.val >l2Curr.val){
                    l1Curr.next = l2Curr;
                    l2Curr.next = l1Next;
                }
                l1Curr = l1Next;
                l1Next = null;
            }else {
                if(firstTimes == 1){
                    head = l2Curr;
                }
                ListNode l2Next = l2Curr.next;
                if(l2Next!=null && l2Next.val>l1Curr.val){
                    l2Curr.next = l1Curr;
                    l1Curr.next = l2Next;
                }
                l2Curr = l2Next;
                l2Next = null;
            }
        }
        if(l1Curr.next == null && l2Curr.next!=null){
            l1Curr.next = l2Curr;
        }else if (l1Curr.next != null && l2Curr.next==null){
            l2Curr.next = l1Curr;
        }
        return head;

    }
}