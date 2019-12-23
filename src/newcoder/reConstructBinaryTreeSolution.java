package newcoder;

import java.util.Arrays;


public class reConstructBinaryTreeSolution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return root;
    }

    public void TravPost(TreeNode root) {
        if(root==null){
            return ;
        }
        TravPost(root.left);
        TravPost(root.right);
        System.out.println(root.val);

    }
    public void TravPre(TreeNode root) {
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        TravPre(root.left);

        TravPre(root.right);


    }


    public static void main(String[] args) {
        reConstructBinaryTreeSolution r = new reConstructBinaryTreeSolution();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = r.reConstructBinaryTree(pre, in);

        r.TravPre(root);
    }


}
