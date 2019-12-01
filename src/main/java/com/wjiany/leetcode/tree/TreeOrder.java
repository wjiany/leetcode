package com.wjiany.leetcode.tree;

import java.util.*;

public class TreeOrder {

    //层次遍历
    public void levelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        if(treeNode!=null) queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            System.out.println(remove.val);
            if (remove.left !=null) queue.add(remove.left);
            if (remove.right!=null) queue.add(remove.right);
        }
    }
    //Z层次遍历
    public void zLevelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(treeNode!=null) queue.add(treeNode);
        Boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if(flag){
                    if (remove.left !=null) stack.push(remove.left);
                    if (remove.right!=null) stack.push(remove.right);
                }else {
                    if (remove.right!=null) stack.push(remove.right);
                    if (remove.left !=null) stack.push(remove.left);
                }
            }
            res.add(list);
            flag = !flag;
            while (!stack.isEmpty()){
                queue.add(stack.pop());
            }
        }
    }
    //前序非递归
    public void preOrder2(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        if(treeNode!=null) stack.push(treeNode);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right!=null) stack.push(pop.right);
            if (pop.left !=null) stack.push(pop.left);
        }
    }
    //后序非递归
    public void postOrder2(TreeNode treeNode){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(treeNode!=null) stack.push(treeNode);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(0,pop.val);
            if (pop.left !=null) stack.push(pop.left);
            if (pop.right!=null) stack.push(pop.right);
        }
    }

    //前序非递归
    public void preOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            if(treeNode != null){  // while(treeNode!=NULL)
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }else {    //if(!s.empty())
                TreeNode pop = stack.pop();
                treeNode = pop.right;
            }
        }
    }

    //中序非递归 liuxi
    public void inOrder2(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = treeNode;
        while (treeNode != null ||!stack.isEmpty()){
            while (treeNode != null ){
                stack.push(treeNode);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            curr = pop.right;
        }

    }

    //中序非递归
    public void inOrder(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()){
            if(treeNode != null){  // while(treeNode!=NULL)
                stack.push(treeNode);
                treeNode = treeNode.left;
            }else {    //if(!s.empty())
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                treeNode = pop.right;
            }
        }
    }
    public void preOrderRe(TreeNode treeNode){
        if(treeNode != null){
            System.out.println(treeNode.val);
            preOrderRe(treeNode.left);
            preOrderRe(treeNode.right);
        }
    }
}

