package com.wjiany.rebuild.datastructure.tree;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * e二分搜索树
 */

public class BST <E extends Comparable<E>>{
    @Test
    public void test(){
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(8);
        bst.add(4);
        bst.add(2);
        bst.preOrder();
    }
    private Node root;
    private int size;
    private class Node{
        public E e;
        private Node left ;
        private Node right ;

        public Node(E e) {
            this.e = e;
            this.left= null;
            this.right = null;
        }
    }
    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e){
         root = add(root, e);
    }
    public boolean isEmpty(Node root){
        return size == 0;
    }

    private Node add(Node node, E e) {
        if(node == null){
            size++;
            node = new Node(e);
           return node;
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }
    public boolean contains(E e){
        return contains(root ,e);
    }

    private boolean contains(Node node, E e) {
        if(node == null){
            return false;
        }
        if(node.e.compareTo(e) == 0){
            return true;
        }
        if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }
    public void  preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root){
        if(root != null){
            System.out.println(root.e);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
