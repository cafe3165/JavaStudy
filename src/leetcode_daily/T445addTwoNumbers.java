package leetcode_daily;

import java.util.List;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-05-28
 */
public class T445addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        int carry = 0, res = 0;
        ListNode dummy=new ListNode(-1);
        ListNode pre=null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int n1 = s1.pop(), n2 = s2.pop();
            res = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            ListNode node=new ListNode(res);
            dummy.next=node;
            node.next=pre;
            pre=node;
        }
        while(!s1.isEmpty() ){
            int num=s1.pop();
            res=(num+carry)%10;
            carry=(num+carry)/10;
            ListNode node=new ListNode(res);
            dummy.next=node;
            node.next=pre;
            pre=node;
        }
        while(!s2.isEmpty() ){
            int num=s2.pop();
            res=(num+carry)%10;
            carry=(num+carry)/10;
            ListNode node=new ListNode(res);
            dummy.next=node;
            node.next=pre;
            pre=node;
        }
        if(carry!=0){
            ListNode node=new ListNode(carry);
            dummy.next=node;
            node.next=pre;
//            pre=node;
        }



        return dummy.next;

    }

    public static ListNode gen(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = null;
        int pos = 10;
        while (n > 0) {
            int tmp = n % pos;
            ListNode ln = new ListNode(tmp);
            dummy.next = ln;
            ln.next = pre;
            pre = ln;
            n /= pos;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n1 = 899;
        int n2 = 2;
        ListNode num1 = gen(n1), num2 = gen(n2);


        System.out.println(addTwoNumbers(num1, num2));

    }
}
