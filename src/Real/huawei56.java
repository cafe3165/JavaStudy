package Real;

import lombok.val;

import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Author:cafe3165
 * Date:2020-05-06
 */
public class huawei56 {
    public static class TreeNode {
        int val;
        int pre;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void solve(TreeNode node) {
        dfsPre(node,0);
        dfs(node);
//        System.out.println("666");
    }
    public static void dfs(TreeNode tn){

    }

    public static void dfsPre(TreeNode tn,int num) {
        if (tn != null) {
            num+=tn.val;
            tn.pre=num;
            System.out.print(tn.val + "  ");
            dfsPre(tn.left,num);
            dfsPre(tn.right,num);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode gen() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(-1);
        return root;
    }


    public static void main(String[] args) throws IOException {
//        -1(3,2(0,-1));
        solve(gen());


    }
}
