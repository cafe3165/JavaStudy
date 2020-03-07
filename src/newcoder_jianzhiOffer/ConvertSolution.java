package newcoder_jianzhiOffer;

import java.util.ArrayList;

public class ConvertSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
//    要求不能创建任何新的结点，只能调整树中结点指针的指向。
    ArrayList<TreeNode> treeNodeList = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        inorder(pRootOfTree);
        pRootOfTree = convert(pRootOfTree);
        return pRootOfTree;
    }


    public void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        treeNodeList.add(root);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public TreeNode convert(TreeNode root) {

        for (int i = 0; i < treeNodeList.size() - 1; i++) {
            treeNodeList.get(i).right = treeNodeList.get(i + 1);
            treeNodeList.get(i + 1).left = treeNodeList.get(i);
        }

        return treeNodeList.get(0);
    }

    public TreeNode GenTree() {
//        {1,3,2,4,5,6},
        TreeNode r = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        r.left = n1;
        r.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;


        return r;

    }

    public static void main(String[] args) {
        ConvertSolution c = new ConvertSolution();
        TreeNode root = c.GenTree();
        TreeNode r = c.Convert(root);
        while (r.right != null) {
            System.out.println(r.val);
            r = r.right;
        }
    }

}
