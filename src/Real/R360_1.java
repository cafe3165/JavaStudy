package Real;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class R360_1 {
    public static class people {
        public int num;
        public int atk;
        public int game;

        public people(int num, int atk) {
            this.num = num;
            this.atk = atk;
            game = 0;
        }
    }
    public static int[] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Deque<people> pl = new LinkedList<>();
//        people[] ps = new people[n];
        max=new int[n];
        for (int i = 0; i < n; i++) {
            int tmp=sc.nextInt();
            pl.add(new people(i, tmp));
            max[i]=tmp;
        }
        Arrays.sort(max);
        solve2(n, m, pl);
//        4 3 1 3 2 4
    }

    private static void solve(int n, int m, Deque<people> pl) {
//        if(m>n){
//
//        }
        int res = 0;
        while (true) {
            people p1 = pl.pollFirst();
            people p2 = pl.pollFirst();
            if (p1.game == m) {
                break;
            } else {
                if (p1.atk > p2.atk) {
                    p1.game++;
                    pl.addFirst(p1);
                    pl.addLast(p2);

                } else {
                    p2.game++;
                    pl.addFirst(p2);
                    pl.addLast(p1);
                }
                res++;
            }
        }
        System.out.println(res);
    }

    private static void solve2(int n, int m, Deque<people> pl) {
//        if(m>n){
//
//
//        }
        int res = 0;
        while (true) {
            people p1 = pl.pollFirst();
            people p2 = pl.pollFirst();
            if (p1.game == m) {
                break;
            } else {
                if (p1.atk > p2.atk) {
                    p1.game++;
                    pl.addFirst(p1);
                    pl.addLast(p2);

                } else {
                    p2.game++;
                    pl.addFirst(p2);
                    pl.addLast(p1);
                }
                res++;
            }
        }
        System.out.println(res);
    }


}
