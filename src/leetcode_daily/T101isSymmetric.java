package leetcode_daily;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * Author:cafe3165
 * Date:2020-05-31
 */
public class T101isSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }


        return jude(root.left, root.right);
    }


    private static boolean jude(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return jude(left.left, right.right)&&jude(left.right,right.left);
        } else {
            return false;
        }
    }

    public static TreeNode gen() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;

    }

    public static void main(String[] args) {
        isSymmetric(gen());

    }
}
