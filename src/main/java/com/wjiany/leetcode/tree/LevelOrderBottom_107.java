package com.wjiany.leetcode.tree;

import java.util.*;

public class LevelOrderBottom_107 {
    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
            lists.add(0,list);
        }
        return lists;
    }
}
