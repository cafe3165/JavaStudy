package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-20
 */
public class T124maxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lm = dfs(root.left);
        int rm = dfs(root.right);
        int m1 = Math.max(lm + rm + root.val, Math.max(lm + root.val, rm + root.val));
        max = Math.max(max, Math.max(m1, root.val));
        return Math.max(root.val, Math.max(lm + root.val, rm + root.val));
    }


    private TreeNode gen() {
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        return n1;
    }

    public static void main(String[] args) {
        T124maxPathSum t = new T124maxPathSum();
        t.maxPathSum(t.gen());
    }


}
