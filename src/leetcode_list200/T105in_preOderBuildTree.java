package leetcode_list200;

import java.util.Arrays;

public class T105in_preOderBuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        T105in_preOderBuildTree t = new T105in_preOderBuildTree();
        TreeNode node = t.buildTree(preorder, inorder);
        System.out.println(node.val);
//        int[] test=Arrays.copyOfRange(inorder,1,4);
//
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]);
//        }
    }
}
