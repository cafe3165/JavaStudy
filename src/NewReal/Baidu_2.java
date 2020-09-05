package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-03
 */
public class Baidu_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), m = sc.nextInt();
            Queue<int[][]> noQue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();
                int[][] no = new int[k][2];
                for (int j = 0; j < k; j++) {
                    no[j][0] = sc.nextInt();
                    no[j][1] = sc.nextInt();
                }
                noQue.offer(no);
            }
            int s=noQue.size();
            while (s>1) {
                int[][] a = noQue.poll();
                int[][] b = noQue.poll();
                int[][] c = intersection(a, b);
                noQue.add(c);
                s--;
            }
            int[][] res = noQue.poll();
            int r = res.length;
            int count = 0;
            List<Integer> reslist = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                int[] tmp = res[i];
                for (int j = tmp[0]; j <= tmp[1]; j++) {
                    reslist.add(j);
                    count++;
                }
            }
            Collections.sort(reslist);
            System.out.println(count);
            for (int i = 0; i < reslist.size(); i++) {
                if (i != reslist.size() - 1) {
                    System.out.print(reslist.get(i) + " ");
                } else {
                    System.out.print(reslist.get(i));
                }
            }
        }


    }

    public static int[][] intersection(int[][] a, int[][] b) {
        List<int[]> nolist = new ArrayList<>();
        int l1 = a.length, l2 = b.length, p = 0, q = 0;
        while (p < l1 && q < l2) {
            if (a[p][0] <= b[q][0]) {
                if (a[p][1] >= b[q][1]) {
                    int[] tmp = {b[q][0], b[q][1]};
                    nolist.add(tmp);
                } else if (a[p][1] >= b[q][0] && a[p][1] < b[q][1]) {
                    int[] tmp = {b[q][0], a[p][1]};
                    nolist.add(tmp);
                }
            } else if (a[p][0] > b[q][0]) {
                if (b[q][1] >= a[p][1]) {
                    int[] tmp = {a[p][0], a[p][1]};
                    nolist.add(tmp);
                } else if (b[q][1] >= a[p][0] && b[q][1] < a[p][1]) {
                    int[] tmp = {a[p][0], b[q][1]};
                    nolist.add(tmp);
                }
            }
            if (a[p][1] > b[q][1]) {
                q++;
            } else {
                p++;
            }
        }
        int len = nolist.size();
        int[][] ans = new int[len][2];
        for (int i = 0; i < len; i++) {
            ans[i][0] = nolist.get(i)[0];
            ans[i][1] = nolist.get(i)[1];
        }
        return ans;
    }
}
