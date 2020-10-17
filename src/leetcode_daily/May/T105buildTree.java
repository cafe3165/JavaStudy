package leetcode_daily.May;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-22
 */
public class T105buildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static Map<Integer, Integer> nodeMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = inorder.length;
        nodeMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            nodeMap.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, len - 1, 0, len - 1);
        return root;
    }

    public static TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 >r1){
            return null;
        }
// preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        int pre_root = l1;
        int in_root = nodeMap.get(preorder[pre_root]);
        TreeNode root = new TreeNode(inorder[in_root]);
        int leftSize = in_root - l2;
        root.left = build(preorder, inorder, l1 + 1, l1 + leftSize, l2, in_root - 1);
        root.right = build(preorder, inorder, l1 + leftSize + 1, r1, in_root + 1, r2);
        return root;
    }

    //             3
//            / \
//          9    20
//             /  \
//           15    7
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
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
                root.left = buildTree2(pre_left, in_left);
                root.right = buildTree2(pre_right, in_right);
                break;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        buildTree2(preorder, inorder);
    }
}
