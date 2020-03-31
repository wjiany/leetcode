package com.wjiany.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Rob_337 {

    /**
     * https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
     * @param root
     * @return
     */
    public int rob_1(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += (rob_1(root.left.left) + rob_1(root.left.right));
        }

        if (root.right != null) {
            money += (rob_1(root.right.left) + rob_1(root.right.right));
        }

        return Math.max(money, rob_1(root.left) + rob_1(root.right));
    }
    public int rob_2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return rob_2(root, memo);
    }

    public int rob_2(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;

        if (root.left != null) {
            money += (rob_2(root.left.left, memo) + rob_2(root.left.right, memo));
        }
        if (root.right != null) {
            money += (rob_2(root.right.left, memo) + rob_2(root.right.right, memo));
        }
        int result = Math.max(money, rob_2(root.left, memo) + rob_2(root.right, memo));
        memo.put(root, result);
        return result;
    }
    public int rob_3(TreeNode root) {
        int[] result = fun_3(root);
        return Math.max(result[0], result[1]);
    }

    private int[] fun_3(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = fun_3(root.left);
        int[] right = fun_3(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}