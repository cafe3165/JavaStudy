package newcoder_jianzhiOffer;

public class MirrorSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode GenTree() {
//        {8,8,7,9,2,#,#,#,#,4,7},
        TreeNode r1 = new TreeNode(8);
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        r1.left = n1;
        r1.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right = n6;

        return r1;

    }

    public void Mirror(TreeNode root) {

        if(root==null){
            return ;
        }
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;

        Mirror(root.left);
        Mirror(root.right);

    }

//    public TreeNode Exchange(TreeNode root){
//        if(root==null){
//            return null;
//        }
//        TreeNode tmp=root.right;
//        root.right=root.left;
//        root.left=tmp;
//
//         Exchange(root.left);
//         Exchange(root.right);
//         return root;
//
//    }
    public void TravPre(TreeNode root) {
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        TravPre(root.left);
        TravPre(root.right);


    }


    public static void main(String[] args) {
        MirrorSolution m = new MirrorSolution();
        TreeNode t=m.GenTree();
        m.Mirror(t);
        m.TravPre(t);
    }
}
