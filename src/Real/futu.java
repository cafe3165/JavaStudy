package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Author:cafe3165
 * Date:2020-04-28
 */
public class futu {
    public static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode initTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        TreeNode[] trees = new TreeNode[arr.length];
        trees[0] = root;
        for (int i = 1; i < arr.length; i++) {
            TreeNode tmp = new TreeNode(arr[i]);
            trees[i] = tmp;
        }
        for (int i = 0; i < Math.log(arr.length); i++) {
            if (i * 2 < arr.length) {
                trees[i].left = trees[i * 2+1];
            }
            if (i * 2 + 2 < arr.length) {
                trees[i].right = trees[i * 2 + 2];
            }
        }

        return root;

    }


    public static List<Integer> list;

    public static void main(String[] args) {

        int[] tree = {5, 2, 6, 1, 3};
        TreeNode root = initTree(tree);
        int[] a = {1, 3, 2, 6, 5};
        int[] b = {1, 6, 3, 2, 5};
        list = new ArrayList<>();
        boolean f1 = solve(a, root);
        list.clear();
        boolean f2 = solve(b, root);
        System.out.println(f1);
        System.out.println(f2);
    }

    private static boolean solve(int[] arr, TreeNode root) {
        backTree(root);
        for (int i = 0; i < arr.length; i++) {
            if (list.get(i) != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void backTree(TreeNode treeNode) {
        if (treeNode.left != null) {
            backTree(treeNode.left);
        }
        if (treeNode.right != null) {
            backTree(treeNode.right);
        }
        if (treeNode != null) {
            list.add(treeNode.val);
        }
    }
}
