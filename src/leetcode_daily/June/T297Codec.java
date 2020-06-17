package leetcode_daily.June;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-16
 */
public class T297Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");

    }

    private String rSerialize(TreeNode root, String s) {
        if (root == null) {
            s += "null,";
        } else {
            s += root.val + ",";
            s = rSerialize(root.left, s);
            s = rSerialize(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(node));
        return rDeserialize(list);
    }

    private TreeNode rDeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }

    public TreeNode gen() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        return n1;
    }

    public static void main(String[] args) {
        T297Codec t = new T297Codec();
        String str = t.serialize(t.gen());
        System.out.println(str);
//        System.out.println(t.deserialize(str));
        t.deserialize(str);
    }
}
