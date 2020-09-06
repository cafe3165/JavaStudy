package NewReal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class Tencent_1 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head1 = new ListNode(-1), head2 = new ListNode(-1);
        ListNode p = head1, q = head2;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(sc.nextInt());
            p.next = node;
            p = p.next;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            ListNode node = new ListNode(sc.nextInt());
            q.next = node;
            q = q.next;
        }
        List<Integer> resList=solve(head1,head2);
        for (int i = 0; i < resList.size(); i++) {
            if(i<resList.size()-1){
                System.out.print(resList.get(i)+" ");
            }else{
                System.out.println(resList.get(i));
            }
        }

    }

    public static List<Integer> solve(ListNode h1, ListNode h2) {
        List<Integer> ansList = new ArrayList<>();
        ListNode p = h1.next, q = h2.next;
        while (p != null && q != null) {
            if (p.val == q.val) {
                ansList.add(p.val);
                p=p.next;
                q=q.next;
            } else if (p.val > q.val) {
                p = p.next;
            } else {
                q = q.next;
            }
        }
        return ansList;
    }
}
