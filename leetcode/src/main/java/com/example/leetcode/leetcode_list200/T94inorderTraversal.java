package com.example.leetcode.leetcode_list200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-06-07
 */
public class T94inorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }

    public static void main(String[] args) {
        T94inorderTraversal t = new T94inorderTraversal();
        t.inorderTraversal(t.gen());

    }
}
