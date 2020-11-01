package newReal2;

import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-10-18
 */
public class WYHY_M1 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            val = value;
        }
    }

    /* 1>如果树为空，则直接返回错。
        2>如果树不为空：层次遍历二叉树 ；
        2.1>如果遇到一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树；
        2.2>如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
        2.3>如果遇到一个结点，左孩子不为空，右孩子为空；或者左右孩子都为空；
则该节点之后的队列中的结点都为叶子节点；
该树才是完全二叉树，否则就不是完全二叉树。*/
    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null && cur.right != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
                continue;
            }
            if (cur.left == null && cur.right != null) {
                return false;
            }
            if (cur.left == null && cur.right == null
                    || cur.left != null && cur.right == null) {
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if (!isLeaf(queue)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isLeaf(Queue queue) {
        Iterator<TreeNode> it = queue.iterator();
        while (it.hasNext()) {

            TreeNode cur = it.next();
            System.out.println(cur.val);
            if (cur.left != null || cur.right != null) {
                return false;
            }
        }
        return true;
    }

    public static TreeNode gen () {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        return root;

    }

    public static void main(String[] args) {
        TreeNode root =gen();
        boolean res = isCompleteBinaryTree(root);
        System.out.println(res);

    }
}
