package com.leetcode.wjiany.tree;

/**
 * 翻转二叉树
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = new TreeNode(0);
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
