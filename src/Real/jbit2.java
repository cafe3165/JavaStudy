package Real;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-28
 */
public class jbit2 {
    public static class edge {
        public int start;
        public int end;
        public int w;

        public edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    public static int kruskal(edge[] es, int n) {
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = 1;
        }
        int sum = 0;
        for (edge e : es) {
            int st = find(p, e.start);
            int end = find(p, e.end);
            if (st != end) {
                p[st] = end;
                sum += e.w;
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (find(p, i) != find(p, j)) {
                    return -1;
                }
            }
        }
        return sum;
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
            int w = sc.nextInt();
            es[i] = new edge(s, e, w);
        }
        Arrays.sort(es, Comparator.comparingInt(o -> o.w));
        System.out.println(kruskal(es, n));
    }
}
