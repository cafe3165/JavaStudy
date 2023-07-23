package com.example.m;

import com.example.leetcode.labuladong.HighFrequnt.LRUCache;
import com.example.leetcode.utils.TreeNode;
import net.sf.json.util.JSONUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2023-04-22
 */
public class Xy2 {

    public static List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> preList = new ArrayList<>();
        if (root == null) {
            return preList;
        }
        preList.add(root);

        Stack<TreeNode> leftSt = new Stack<>();
        Stack<TreeNode> rightSt = new Stack<>();

        if (root.left != null) {
            leftSt.push(root.left);
        }
        if (root.right != null) {
            rightSt.push(root.right);
        }

        while (!leftSt.isEmpty() || !rightSt.isEmpty()) {
            if (!leftSt.isEmpty()) {
                TreeNode cur = leftSt.pop();
                preList.add(cur);
                if (cur.left != null) {
                    leftSt.push(cur.left);
                }
                if (cur.right != null) {
                    rightSt.push(cur.right);
                }
                continue;
            }
            if (!rightSt.isEmpty()) {
                TreeNode cur = rightSt.pop();
                preList.add(cur);
                if (cur.left != null) {
                    leftSt.push(cur.left);
                }
                if (cur.right != null) {
                    rightSt.push(cur.right);
                }
            }

        }


        return preList;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        node3.left = node5;

        List<TreeNode> preList = preOrder(root);
        for (TreeNode node : preList) {
            System.out.println(node.val);
        }
        System.out.println(JSONUtils.valueToString(preList));



    }
}
