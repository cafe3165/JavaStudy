package com.example.leetcode.leetcode_daily.June;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Author:cafe3165
 * Date:2020-06-19
 */
public class T1028recoverFromPreorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
//        char[] chs = S.toCharArray();
        int index = 0, len = S.length();
//        TreeNode root = new TreeNode();
        Deque<TreeNode> path = new LinkedList<>();
        while (index < len) {
            int level = 0;
            while (S.charAt(index) == '-') {
                level++;
                index++;
            }
            int val = 0;
            while (index < len && Character.isDigit(S.charAt(index))) {
                val = val * 10 + S.charAt(index) - '0';
                index++;
            }
            TreeNode node = new TreeNode(val);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }


    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";
        T1028recoverFromPreorder t = new T1028recoverFromPreorder();
        t.recoverFromPreorder(S);

    }
}
