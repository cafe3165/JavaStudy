package Real;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-08
 */
public class wangyi_4 {
    public static class edge {
        public int start;
        public int end;
        public long w;

        public edge(int start, int end, long w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    public static long kruskal(edge[] es, int n) {

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = 1;
        }
        long Max = Integer.MIN_VALUE;
        long Min = Integer.MAX_VALUE;
        for (edge e : es) {
            int st = find(p, e.start);
            int end = find(p, e.end);
            if (st != end) {
                p[st] = end;
                Min = Math.min(Min, e.w);
                Max = Math.max(Max, e.w);
            }
        }
        return Max - Min;
    }

    public static int find(int[] p, int index) {
        while (p[index] > 1) {
            index = p[index];
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        edge[] es = new edge[m];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            long w = sc.nextLong();
            es[i] = new edge(s, e, w);
        }
        long res = Integer.MAX_VALUE;
//        res=Math.min(res,kruskal(es, n));
        for (int j = 0; j <m ; j++) {
            edge tmp = es[0];
            for (int i = 0; i < m - 1; i++) {
                es[i] = es[i + 1];
            }
            es[m - 1] = tmp;
            res=Math.min(res,kruskal(es, n));
        }
        System.out.println(res);
    }
}
