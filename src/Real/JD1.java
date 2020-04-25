package Real;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-18
 */
public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] conflict = new int[N];
//        Arrays.fill(conflict,1);
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][0] >= arr[j][1] || arr[j][0] >= arr[i][1]){
                    continue;
                }
                else {
                    conflict[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max,conflict[i]);
        }

        System.out.println(max);
    }


}
