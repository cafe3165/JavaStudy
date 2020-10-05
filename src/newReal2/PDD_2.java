package newReal2;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-26
 */
public class PDD_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        char[][] graph = new char[N][M];
        int xt = 0, yt = 0;
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j);
                if (s.charAt(j) == 'T') {
                    xt = i;
                    yt = j;
                }
            }
        }
    }
}
