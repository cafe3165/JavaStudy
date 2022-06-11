package com.example.leetcode.leetcode_list400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2021-03-11
 */
public class T617mergeTrees {
    class TreeNode {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            TreeNode node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        }
    }

    public TreeNode[] gen() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        root1.left = n1;
        root1.right = n2;
        n1.left = n3;
        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(3);
        TreeNode m3 = new TreeNode(4);
        TreeNode m4 = new TreeNode(7);
        root2.left = m1;
        root2.right = m2;
        m1.right = m3;
        m2.right = m4;
        TreeNode[] tns = new TreeNode[2];
        tns[0] = root1;
        tns[1] = root2;
        return tns;

    }


    public static void main(String[] args) {
        T617mergeTrees t = new T617mergeTrees();
        TreeNode[] tns = t.gen();
        TreeNode n = t.mergeTrees(tns[0], tns[1]);
        System.out.println(n);
    }
}

