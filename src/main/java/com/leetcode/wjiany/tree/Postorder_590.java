package com.leetcode.wjiany.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Postorder_590 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root !=null){
            if(root.children!=null){
                for (Node node: root.children ) {
                    postorder(node);
                }
            }
            list.add(root.val);
        }
        return list;
    }
    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorder_2(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            list.add(0,pop.val);
            List<Node> children = pop.children;
            if(children!=null){
                int size = children.size();
                for (int i = 0;i<size;i++){
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }
}
