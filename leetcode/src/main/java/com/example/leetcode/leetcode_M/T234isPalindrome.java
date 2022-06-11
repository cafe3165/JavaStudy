package com.example.leetcode.leetcode_M;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-15
 */
public class T234isPalindrome {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        List<ListNode> ans = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            ans.add(p);
            p = p.next;
        }
//        int halflen = ans.size()%2==0?ans.size()/2:ans.size()/2+1;
        int halflen = ans.size()/2;
        for (int i = 0; i < halflen; i++) {
            if (ans.get(i).val!= ans.get(ans.size()-i-1).val) {
                return false;
            }
        }


        return true;

    }

    public static ListNode gen() {
        ListNode root = new ListNode(1);
        ListNode p = root;
        int[] r = {2,3, 2, 1};
        for (int i = 0; i < r.length; i++) {
            p.next = new ListNode(r[i]);
            p = p.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = gen();
        T234isPalindrome t = new T234isPalindrome();
        t.isPalindrome(root);


    }
}
