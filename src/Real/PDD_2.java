package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-02
 */
public class PDD_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] touzi = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                touzi[i][j] = sc.nextInt();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] f = new boolean[N];

        for (int i = 0; i < N; i++) {
            List<Integer> tmp=new ArrayList<>();
            if(!f[i]){
                tmp.add(i);
                f[i]=true;
            }
            for (int j = i + 1; j < N && !f[j]; j++) {
                if(jude(touzi[i],touzi[j])){
                    tmp.add(j);
                    f[j]=true;
                }
            }
            res.add(tmp);
        }

        System.out.println(jude(touzi[0], touzi[1]));


    }

    public static boolean jude(int[] t1, int[] t2) {
        int m = 0;
        for (int i = 0; i < 3; i++) {
            m = 0;
            for (int j = 0; j < 6; j++) {
                if (t1[i] == t2[j] && t1[5 - i] == t2[5 - i]) {
                    m = 1;
                    t2[j] = 0;
                    t2[5 - j] = 0;
                    break;
                }
            }
            if (m == 0) {
                break;
            }
        }
        if (m == 0) {
            return true;
        } else {
            return false;
        }
    }
}
