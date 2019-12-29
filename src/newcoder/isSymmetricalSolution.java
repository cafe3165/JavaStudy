package newcoder;

public class isSymmetricalSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || jude(pRoot.left, pRoot.right);

    }

    public boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }else {
            return jude(node1.left,node2.right)&&jude(node1.right,node2.left);
        }

    }

    public TreeNode GenTree() {
//        {1,3,2,4,5,6},
        TreeNode r = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);

        r.left = n1;
        r.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;


        return r;

    }

    public static void main(String[] args) {
        isSymmetricalSolution is = new isSymmetricalSolution();
        TreeNode root = is.GenTree();

        System.out.println(is.isSymmetrical(root));


    }
}
