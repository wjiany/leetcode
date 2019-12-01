package com.wjiany.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Preorder_589 {
    /**
     * 递归
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder_1(Node root) {
    if(root != null){
        list.add(root.val);
        List<Node> children = root.children;
        if(children != null){
            for (int i = 0 ; i < children.size() ; i++){
                preorder_1(children.get(i));
            }
        }
    }
        return list;
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            list.add(pop.val);
            List<Node> children = pop.children;
            if(children!=null){
                for (int i = children.size()-1; i>=0;i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }
}
