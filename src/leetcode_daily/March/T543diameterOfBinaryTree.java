package leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-10
 */
public class T543diameterOfBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l, r;
        l = dfs(root.left);
        r = dfs(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;

    }


    public TreeNode con() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        return root;


    }


    public static void main(String[] args) {
        T543diameterOfBinaryTree t = new T543diameterOfBinaryTree();
        TreeNode root = t.con();
        t.diameterOfBinaryTree(root);

    }
}
