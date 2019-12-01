package com.wjiany.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Double sum = 0d;
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode remove = queue.remove();
                sum+=remove.val;
                if(remove.left!=null){
                    queue.add(remove.left);
                }
                if(remove.right!=null){
                    queue.add(remove.right);
                }
            }
            lists.add(sum/size);
        }
        return lists;
    }
}
