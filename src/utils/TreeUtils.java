package utils;
import leetcode_list400.T230kthSmallest.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/4 5:05 下午
 */
public class TreeUtils {
    public static TreeNode buildTree ( Integer[] treeNodes) {
        TreeNode root = new TreeNode(treeNodes[0]);
        int idx = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (idx < treeNodes.length) {
            if (queue.size() == 0) {
                break;
            }
            TreeNode currentNode = queue.poll();
            Integer lVal = treeNodes[idx++];
            if (lVal != null) {
                currentNode.left = new TreeNode(lVal);
                queue.offer(currentNode.left);
            }
            if (idx == treeNodes.length) {
                break;
            }
            Integer rVal = treeNodes[idx++];
            if (rVal != null) {
                currentNode.right = new TreeNode(rVal);
                queue.offer(currentNode.right);
            }
        }
    return root;
    }
}
