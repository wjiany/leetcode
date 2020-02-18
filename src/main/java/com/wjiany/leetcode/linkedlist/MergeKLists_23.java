package com.wjiany.leetcode.linkedlist;

import org.junit.Test;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKLists_23 {

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
        ListNode[] listNodes = new ListNode[]{node1,node11};

        ListNode node = mergeKLists(listNodes);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 参考合并两个有序链表的递归方法
     * @param lists
     * @return
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparing(x->x.val));
        Arrays.stream(lists).forEach(x->{if (x!=null) queue.add(x);});
        return mergeKLists(queue);
        
    }
    // 递归，返回传入的结果
    private ListNode mergeKLists(Queue<ListNode> queue){
        if(queue.size() == 0){
            return null;
        }
        ListNode remove = queue.remove();
        if (remove.next != null){
            queue.add(remove.next);
        }
        remove.next = mergeKLists(queue);
        return remove;
    }
}