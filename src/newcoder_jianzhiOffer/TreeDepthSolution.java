package newcoder_jianzhiOffer;

public class TreeDepthSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {

        return root!=null?Math.max(TreeDepth(root.left), TreeDepth(root.right))+1:0;

    }

    public static void main(String[] args) {

    }
}
