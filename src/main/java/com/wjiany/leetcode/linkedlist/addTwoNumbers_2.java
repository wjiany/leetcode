package com.wjiany.leetcode.linkedlist;

import com.wjiany.leetcode.linkedlist.ListNode;
import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class addTwoNumbers_2 {

    @Test
    public void test(){

        ListNode a = new ListNode(2);
         a.next = new ListNode(4);
         a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
         b.next = new ListNode(6);
         b.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(a, b);
        while (listNode !=null){

            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode node;
        ListNode result = new ListNode(0);
        node = result;
        int addNum = 0;
        while (l1!=null || l2 !=null){
            int val1 = l1 == null?0:l1.val;
            int val2 = l2 == null?0:l2.val;
            int res = val1+val2 +addNum;
            node.next = new ListNode(res % 10);
            addNum = res / 10;
            node = node.next;
            l1 = l1==null?l1:l1.next;
            l2 = l2==null?l2:l2.next;
        }
        if(addNum!=0){
            node.next = new ListNode(addNum);
        }
        return result.next;
    }
}