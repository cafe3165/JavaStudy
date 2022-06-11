package com.example.leetcode.leetcode_daily.July;

import java.util.ArrayList;
import java.util.List;

public class T437pathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int res = 0;


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }


    private void dfs(TreeNode root, int cur, int sum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (cur == sum) {
            res++;
        }
        dfs(root.right, cur, sum);
        dfs(root.left, cur, sum);

    }

//                  10
//                 /  \
//                5   -3
//               / \    \
//              3   2   11
//             / \   \
//            3  -2   1

    public TreeNode gen() {

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
        return n1;

    }


    public static void main(String[] args) {
        int sum = 8;
        T437pathSum t = new T437pathSum();
        t.pathSum(t.gen(), sum);
    }


}
