package com.leetcode.wjiany.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode treeNode1,TreeNode treeNode2){
        if(treeNode1==null && treeNode2==null) return true;
        if(treeNode1==null || treeNode2==null) return false;
        return treeNode1.val==treeNode2.val
                &&isMirror(treeNode1.left,treeNode2.right)
                &&isMirror(treeNode1.right,treeNode2.left);
    }
}
