package com.wjiany.leetcode.tree;

public class MinDepth_111 {
    int deepMin = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        treeDeepMin(root,1);
        return deepMin;
    }
    public void treeDeepMin(TreeNode treeNode ,int deepAdd){
        if(treeNode.left == null && treeNode.right == null){
            deepMin = Math.min(deepAdd,deepMin);
        }else {
            if(treeNode.left != null){
                treeDeepMin(treeNode.left,deepAdd+1);
            }
            if(treeNode.right != null){
                treeDeepMin(treeNode.right,deepAdd+1);
            }
        }
    }
}
