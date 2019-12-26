package newcoder;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;

public class PrintSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode GenTree() {
//        {1,3,2,4,5,6},
        TreeNode r1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        r1.left = n2;
        r1.right = n1;
        n1.left = n4;

        n2.left = n3;
        n2.right = n5;


        return r1;

    }

    private Queue<TreeNode> queue = new LinkedList<>();
    private ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return tree;
        }

        queue.offer(pRoot);
        int cur = 1, next = 0;
        while (!queue.isEmpty()) {
            next=0;
            ArrayList<Integer> list = new ArrayList<>();

            while (cur > 0) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                    next++;
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    next++;
                }
                cur--;
                list.add(t.val);
            }
            tree.add(list);

           cur=next;


        }

        return tree;

    }


    public static void main(String[] args) {
        PrintSolution p = new PrintSolution();
        TreeNode root = p.GenTree();
        System.out.println(p.Print(root));
    }
}
