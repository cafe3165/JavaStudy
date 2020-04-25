package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class duxiaoman1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int[] city = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            city[i] = sc.nextInt();
        }
        int[][] dis = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dis[i][j] = 0;
                    continue;
                }
                if (city[i] > j) {
                    dis[i][j] = A + (city[i] - j) * B;
                } else if (city[i] < j) {
                    dis[i][j] = A + (j - city[i]) * C;
                } else {
                    dis[i][j] = A;
                }
            }
        }
//7 2 1 3 3 6 4 3 4 5 6
        System.out.println(dis);

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N; j++) {
                System.out.print(dis[i][j]+" ");

            }
            System.out.println();

        }

    }
}
