package com.example.leetcode.labuladong.DataStruct;

import javax.swing.tree.TreeNode;

public class BinaryTreeTest {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBST(TreeNode root) {
        return isValidBst(root, null, null);
    }

    private static boolean isValidBst(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static TreeNode getMinNode(TreeNode root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }


    public static TreeNode gen() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(20);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        return root;
    }

    public static void main(String[] args) {
        isBST(gen());
    }
}
