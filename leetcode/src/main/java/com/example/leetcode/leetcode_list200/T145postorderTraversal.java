package com.example.leetcode.leetcode_list200;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-07
 */
public class T145postorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode gen() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        return n1;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            res.add(cur.val);
            if (cur.left != null) {
                stack.addLast(cur.left);
            }
            if (cur.right != null) {
                stack.addLast(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        T145postorderTraversal t = new T145postorderTraversal();
        t.postorderTraversal(t.gen());
    }
}
