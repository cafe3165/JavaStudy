package Real;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-12
 */
public class kuaishou3 {
    public static class consumer {
        int no;
        int pre;
        int bak;
        int del;

        public consumer(int no, int pre, int bak) {
            this.no = no;
            this.pre = pre;
            this.bak = bak;
            this.del = pre - bak;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.next();
        sin = sin.replace("[", "").replace("]", "");
        String[] str = sin.split(",");
        int l = (str.length / 2);
        int[] a = new int[l], b = new int[l];
//        System.out.println(str);
        for (int i = 0; i < l; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < l; i++) {
            b[i] = Integer.parseInt(str[i + l]);

        }


        WaitInLine(a, b);
    }

    public static int[] WaitInLine(int[] a, int[] b) {
        if (a.length == 0) {
            return new int[]{};
        }
        // write code here
        consumer[] cons = new consumer[a.length];
        for (int i = 0; i < a.length; i++) {
            cons[i] = new consumer(i, a[i], b[i]);
        }

        Arrays.sort(cons, new Comparator<consumer>() {
            @Override
            public int compare(consumer o1, consumer o2) {
                return o2.del - o1.del;
            }
        });

//        for (int i = 0; i < cons.length; i++) {
//            int cur1 = cons[i].pre * i + cons[i].bak * (cons.length - i - 1);
//            for (int j = i + 1; j < cons.length; j++) {
//                int cur2 = cons[j].pre * j + cons[j].bak * (cons.length - j - 1);
//                int change1 = cons[i].pre * j + cons[i].bak * (cons.length - j - 1);
//                int change2 = cons[j].pre * i + cons[j].bak * (cons.length - i - 1);
//                if (cur1 + cur2 > change1 + change2) {
////                    cons[i].no = j;
////                    cons[j].no = i;
//                    consumer tmp = cons[i];
//                    cons[i] = cons[j];
//                    cons[j] = tmp;
//                }
//            }
//        }
        int[] res = new int[cons.length];
        for (int i = 0; i < cons.length; i++) {
            res[i] = cons[i].no + 1;
        }


//        System.out.println(cons);

        return res;
    }
}
