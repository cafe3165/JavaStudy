package NewReal;

import javax.swing.tree.TreeNode;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class WY_1 {
    static class TreeNode {
        int no;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int no) {
            this.no = no;
        }
    }

    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        TreeNode root = new TreeNode(1);
        ;
        for (int i = 0; i < n; i++) {
            dfs(root, sc.nextInt(), sc.next(), sc.nextInt());
        }
        find(root);
        System.out.println(res);
    }

    private static void dfs(TreeNode root, int no, String dir, int son) {
        if (root != null && root.no == no) {
            if (dir.equals("left")) {
                root.left = new TreeNode(son);
            } else {
                root.right = new TreeNode(son);
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, no, dir, son);
        }
        if (root.right != null) {
            dfs(root.right, no, dir, son);
        }
    }

    private static void find(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left, right = root.right;
            if (left != null && right != null &&
                    left.left == null && left.right == null &&
                    right.left == null && right.right == null) {
                res++;
            }
            find(root.left);
            find(root.right);
        }
    }


}
