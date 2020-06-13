package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-12
 */
public class T104maxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        return Math.max(l, r);
    }


    public static void main(String[] args) {
        T104maxDepth t = new T104maxDepth();


    }
}
