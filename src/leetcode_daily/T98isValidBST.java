package leetcode_daily;

import javax.swing.tree.TreeNode;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T98isValidBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int pre = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static TreeNode gen() {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = gen();
        System.out.println(isValidBST(root));

    }
}
