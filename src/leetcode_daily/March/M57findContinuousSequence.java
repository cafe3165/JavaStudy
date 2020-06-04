package leetcode_daily.March;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-06
 */
public class M57findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] tmp = new int[r - l + 1];
                for (int i = 0; i <= r - l; i++) {
                    tmp[i] = l + i;
                }
                res.add(tmp);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }

//        return (int[][])res.toArray();
        return res.toArray(new int[res.size()][]);

    }



//    public static class B extends A {
//        public void p() {
//            System.out.println(super.a);
//        }
//    }

    public static void main(String[] args) {
        M57findContinuousSequence m = new M57findContinuousSequence();
        int target = 1;
        m.findContinuousSequence(target);
//        A aa = new A();
//        B bb=new B();
//        System.out.println(aa.a);
////        System.out.println(aa.b);
//        System.out.println(aa.c);
//        System.out.println(bb.a);

    }
}
