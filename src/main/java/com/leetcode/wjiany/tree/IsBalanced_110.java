package com.leetcode.wjiany.tree;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return deepCal(root,0) != -1;
        }
    }
    public int deepCal(TreeNode root,int deep) {
        if(root == null ){
           return deep;
        }
        int left = deepCal(root.left, deep + 1);
        int right = deepCal(root.right, deep + 1);
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(right,left);
    }
}
