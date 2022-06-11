package com.example.leetcode.leetcode_list400;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-20
 */
public class T538convertBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();
    private int index = 1;
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
//        list.add(0);
//        inOrder1(root);
//        inOrder2(root);
//        return root;
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;

    }

    private void inOrder1(TreeNode root) {
        if (root != null) {
            inOrder1(root.left);
            list.add(root.val + list.get(list.size() - 1));
            inOrder1(root.right);
        }
    }

    private void inOrder2(TreeNode root) {
        if (root != null) {
            inOrder2(root.left);
            root.val = list.get(list.size() - 1) - list.get(index - 1);
            index++;
            inOrder2(root.right);
        }
    }

    private TreeNode gen() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(13);
        n1.left = n2;
        n1.right = n3;
        return n1;
    }

    public static void main(String[] args) {
        T538convertBST t = new T538convertBST();
        t.convertBST(t.gen());
    }
}
