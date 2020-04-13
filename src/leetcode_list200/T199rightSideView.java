package leetcode_list200;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-09
 */
public class T199rightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int cur = 0;
        while (!q.isEmpty()) {
            cur = q.size();
            TreeNode node=null;
            for (int i = 0; i < cur; i++) {
               node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(node.val);
        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        T199rightSideView t = new T199rightSideView();
        t.rightSideView(root);
        Map<String, String> m=new HashMap<>();

    }
}
