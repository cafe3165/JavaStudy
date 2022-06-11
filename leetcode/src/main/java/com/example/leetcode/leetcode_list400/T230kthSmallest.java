package com.example.leetcode.leetcode_list400;


import com.example.leetcode.utils.TreeNode;
import com.example.leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/4 5:01 下午
 */
public class T230kthSmallest {


    public static int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);
        treeNodeList.clear();
        return treeNodeList.get(k - 1).val ;
    }

    static List<TreeNode> treeNodeList = new ArrayList<>();

    public static void inOrder(TreeNode root, int k) {
        if (root.left != null) {
            inOrder(root.left, k);
        }
        if (root != null) {
            if (treeNodeList.size() == k){
                return ;
            }
            treeNodeList.add(root);
        }
        if (root.right != null) {
            inOrder(root.right, k);
        }
    }

    public static void main(String[] args) {
        Integer[] treesNode = {5,3,6,2,4,null,null,1};
        int k = 3;
        System.out.println(T230kthSmallest.kthSmallest(TreeUtils.buildTree(treesNode), k));
    }
}


