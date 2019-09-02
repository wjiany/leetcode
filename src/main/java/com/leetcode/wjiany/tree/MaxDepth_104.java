package com.leetcode.wjiany.tree;

public class MaxDepth_104 {
    int maxDeep = 0;
    public int maxDepth(TreeNode root) {
        treeDeep(root,0);
        return maxDeep;
    }
    public void treeDeep(TreeNode node,int deepAdd){

        if(node == null){
            maxDeep = Math.max(maxDeep,deepAdd);
            return;
        }
        treeDeep(node.left,deepAdd+1);
        treeDeep(node.right,deepAdd+1);
    }

}
