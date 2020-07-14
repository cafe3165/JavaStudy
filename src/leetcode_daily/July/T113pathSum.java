package leetcode_daily.July;

import java.util.*;

public class T113pathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//                  5
//                 / \
//                4   8
//               /   / \
//              11  13  4
//             /  \    / \
//            7    2  5   1


    public TreeNode gen() {

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.left = n9;
        n6.right = n10;

        return n1;

    }

    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        dfs(root, 0, sum, deque);
        return res;

    }

    private void dfs(TreeNode root, int cur, int sum, Deque<Integer> path) {
        if (root == null) {
            return;
        }
        cur += root.val;
        path.addLast(root.val);

        if (cur == sum && root.right == null && root.left == null) {
            res.add(new ArrayList<>(path));
            path.pollLast();
            return;
        }
        dfs(root.right,cur,sum,path);
        dfs(root.left,cur,sum,path);

        path.pollLast();
    }


    public static void main(String[] args) {
        T113pathSum t = new T113pathSum();
        t.pathSum(t.gen(), 22);
    }
}
