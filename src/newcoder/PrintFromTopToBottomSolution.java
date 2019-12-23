package newcoder;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottomSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode GenTree() {
//        {8,8,7,9,2,#,#,#,#,4,7},
        TreeNode r1 = new TreeNode(8);
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        r1.left = n1;
        r1.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right = n6;

        return r1;

    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> a = new ArrayList<>();
        if (root == null) {
            return a;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            a.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        PrintFromTopToBottomSolution p = new PrintFromTopToBottomSolution();
        TreeNode t = p.GenTree();
        ArrayList<Integer> a = p.PrintFromTopToBottom(t);
        System.out.println(a);
//        p.TravPre(t);
    }
}
