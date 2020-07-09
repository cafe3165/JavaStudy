package leetcode_list400;

public class T226invertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        inver(root);
        return root;
    }

    private void inver(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            inver(root.left);
            inver(root.right);
        }

    }


    //              4
//                /   \
//               2     7
//              / \   / \
//             1   3 6   9
    private TreeNode gen() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;
    }

    public static void main(String[] args) {
        T226invertTree t = new T226invertTree();
        t.invertTree(t.gen());

    }
}
