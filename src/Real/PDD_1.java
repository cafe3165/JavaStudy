package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-02
 */
public class PDD_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K, N;
        K = sc.nextInt();
        N = sc.nextInt();
        int disAll = K, disCur = 0, back = 0;
        boolean suc = false;
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            disCur += D[i];
            if (disCur == disAll) {
                suc = true;
                break;
            }
            if (disCur > disAll) {
                disAll = disCur - disAll;
                disCur = 0;
                back++;
            }

        }
        if (suc) {
            System.out.println("paradox");
        } else {
            if (back == 0) {
                System.out.println(K - disCur + " " + back);
            } else {
                System.out.println(disAll + " " + back);
            }

        }


    }

}
