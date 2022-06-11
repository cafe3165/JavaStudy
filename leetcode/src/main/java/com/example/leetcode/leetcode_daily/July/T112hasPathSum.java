package com.example.leetcode.leetcode_daily.July;

public class T112hasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//             5
//            / \
//           4   8
//          /   / \
//         11  13  4
//        /  \      \
//       7    2      1

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return dfs(root, root.val, sum);
    }

    private boolean dfs(TreeNode root, int cur, int sum) {
        if (cur == sum&&root.right==null&&root.left==null) {
            return true;
        }
        boolean res=false;
        if(root.left!=null){
            res|=dfs(root.left,cur+root.left.val,sum);
        }
        if(root.right!=null){
            res|=dfs(root.right,cur+root.right.val,sum);
        }
        return res;
    }


    public TreeNode gen() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.right = n9;

        return n1;
    }

    public static void main(String[] args) {
        T112hasPathSum t = new T112hasPathSum();
        int sum = 22;
        System.out.println(t.hasPathSum(t.gen(), sum));
    }
}
