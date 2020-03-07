package newcoder_jianzhiOffer;


public class KthNodeSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int count = 0;
    private TreeNode node = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) {
            return pRoot;
        }
        inOrder(pRoot, k);

        return node;


    }

    public void inOrder(TreeNode root, int k) {

        if (count < k && root.left != null) {
            inOrder(root.left, k);
        }
        if (++count == k) {
            node = root;
        }
        if (count < k && root.right != null) {
            inOrder(root.right, k);
        }


    }


    public TreeNode GenTree() {
//        {5，3，7，2，4，6，8},
        TreeNode r = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(8);
        r.left = n1;
        r.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        return r;

    }

    public static void main(String[] args) {
        KthNodeSolution kth = new KthNodeSolution();
        int k = 3;
        TreeNode t = kth.GenTree();

        System.out.println(kth.KthNode(t, k).val);
    }
}
