package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class WY_4 {
    static class pair {
        int b;
        int g;

        public pair(int b, int g) {
            this.b = b;
            this.g = g;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String boy = sc.nextLine();
        String[] boys = boy.split(" ");
        int[] b = new int[boys.length];
        for (int i = 0; i < boys.length; i++) {
            b[i] = Integer.parseInt(boys[i]);
        }
        int[] g = new int[b.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        pair[] p=new pair[n];
        for (int i = 0; i < n; i++) {
            p[i]=new pair(sc.nextInt(),sc.nextInt());
        }
        System.out.println(b.length);

    }
}
