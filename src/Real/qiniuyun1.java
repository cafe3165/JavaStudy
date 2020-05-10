package Real;

import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-05-07
 */
public class qiniuyun1 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        {1,2,3,4,5,6,7,8,9}
        String str = sc.next();
        String[] strs = str.replace("{", "").replace("}", "").split(",");
        ListNode root = new ListNode(-1);
        ListNode pre = root;
        for (String s : strs) {
            ListNode tmp = new ListNode(Integer.parseInt(s));
            pre.next = tmp;
            pre = pre.next;
        }

        solve(root.next, strs.length);
        pre = root.next;

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        while (pre != null) {
            sb.append(pre.val);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        System.out.println(sb.toString());

    }

    public static ListNode solve(ListNode root, int length) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode pre,cur,bak;
        cur=root;




        return null;

    }
}













