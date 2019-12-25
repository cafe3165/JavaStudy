package newcoder;

import java.util.ArrayList;

public class FindPathSolution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return result;


    }

    public TreeNode GenTree() {
//        {1,3,2,4,5,6},
        TreeNode r1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        r1.left = n2;
        r1.right = n1;
        n1.left = n4;

        n2.left = n3;
        n2.right = n5;


        return r1;

    }

    public static void main(String[] args) {
        FindPathSolution f = new FindPathSolution();
        TreeNode root = f.GenTree();
        int target = 8;
        f.FindPath(root, target);


    }
}
