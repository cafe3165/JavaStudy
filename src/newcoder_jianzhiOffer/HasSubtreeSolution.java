package newcoder_jianzhiOffer;

import java.util.ArrayList;

import java.util.List;

public class HasSubtreeSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (Jude(root1, root2)) {
                return true;
            }
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);


    }

    public boolean Jude(TreeNode root1, TreeNode root2) {
        if (root2 == null && root1 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
//        子结构已经是null了，但是父树还有子树，所以root2.val会报错
        if (root1.val == root2.val) {
            return Jude(root1.left, root2.left) && Jude(root1.right, root2.right);
        }
        return false;


    }


    public List<TreeNode> GenTree() {
//        {8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
        List<TreeNode> lt = new ArrayList<TreeNode>();
        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(8);
//
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


        TreeNode n8 = new TreeNode(9);
        TreeNode n9 = new TreeNode(2);
        r2.left = n8;
        r2.right = n9;


        lt.add(r1);
        lt.add(r2);
        return lt;
    }


    public static void main(String[] args) {
        HasSubtreeSolution h = new HasSubtreeSolution();
        List<TreeNode> lt = h.GenTree();
        ;
        System.out.println(h.HasSubtree(lt.get(0), lt.get(1)));
    }

}
