package leetcode_list200;


import javax.swing.tree.TreeNode;

/**
 * Author:cafe3165
 * Date:2020-06-13
 */
public class T114flatten {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode head=root;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode left_right = root.left;
                while (left_right.right!= null) {
                    left_right = left_right.right;
                }
                left_right.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
        return;
    }

    public TreeNode gen() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        return n1;
    }

    public static void main(String[] args) {
        T114flatten t = new T114flatten();
        t.flatten(t.gen());

    }
}
