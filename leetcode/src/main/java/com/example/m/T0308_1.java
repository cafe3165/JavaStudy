package com.example.m;

/**
 * Author:cafe3165
 * Date:2023-03-08
 */
public class T0308_1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int res = Integer.MIN_VALUE;

    public static int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    private static void dfs (TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left != null && root.right != null) {
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (leftVal + 1 == root.val && rightVal - 1 == root.val) {
                res = Math.max(res, dfsLt(root.left, 0) + dfsGt(root.right, 0) + 1);
            } else if (leftVal - 1 == root.val && rightVal + 1 == root.val) {
                res = Math.max(res, dfsLt(root.right, 0) + dfsGt(root.left, 0) + 1);
            }
        } else if (root.left != null && root.left.val - 1 == root.val) {
            res = Math.max(res, dfsLt(root.left, 0));
        } else if (root.left != null && root.left.val + 1 == root.val) {
            res = Math.max(res, dfsGt(root.left, 0));
        } else if (root.right != null && root.right.val - 1 == root.val) {
            res = Math.max(res, dfsLt(root.right, 0));
        } else if (root.right != null && root.right.val + 1 == root.val) {
            res = Math.max(res, dfsGt(root.right, 0));
        }


        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }

    }

    private static int dfsLt(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        if (root.left != null && root.left.val == root.val - 1
        && root.right != null && root.right.val == root.val - 1) {
            return Math.max(dfsLt(root.right, num + 1), dfsLt(root.left, num + 1));
        }
        if (root.left != null && root.left.val == root.val - 1) {
            return dfsLt(root.left, num + 1);
        }
        if (root.right != null && root.right.val == root.val - 1) {
            return dfsLt(root.right, num + 1);
        }

        return num;
    }

    private static int dfsGt(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        if (root.left != null && root.left.val == root.val + 1
                && root.right != null && root.right.val == root.val + 1) {
            return Math.max(dfsLt(root.right, num + 1), dfsLt(root.left, num + 1));
        }
        if (root.left != null && root.left.val == root.val + 1) {
            return dfsLt(root.left, num + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            return dfsLt(root.right, num + 1);
        }

        return num;
    }

    public static void main(String[] args) {
        {
            TreeNode root = new TreeNode(4);
            TreeNode left = new TreeNode(3);
            left.left = new TreeNode(1);
            left.right = new TreeNode(2);
            root.left = left;
            root.right = new TreeNode(5);
            System.out.println(longestConsecutive(root));
        }
        {
            TreeNode root = new TreeNode(5,
                    new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(4), new TreeNode(5))),
                    new TreeNode(6, null, new TreeNode(7))
            );
            System.out.println(longestConsecutive(root));
        }
    }

}
