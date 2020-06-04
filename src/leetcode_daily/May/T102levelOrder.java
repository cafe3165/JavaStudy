package leetcode_daily.May;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T102levelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> resTmp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode tn = q.poll();
                if (tn.left != null) {
                    q.add(tn.left);
                }
                if (tn.right != null) {
                    q.add(tn.right);
                }
                resTmp.add(tn.val);
            }
            res.add(resTmp);
        }
        return res;
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
        List<List<Integer>> list = levelOrder(root);

    }
}
