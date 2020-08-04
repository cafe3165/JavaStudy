package Real;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-02
 */
public class PDD_4 {
    static class NoonFood {
        public int hot;
        public int dili;

        public NoonFood(int hot, int dili) {
            this.hot = hot;
            this.dili = dili;
        }
    }

    static class NightFood {
        public int hot;
        public int dili;

        public NightFood(int hot, int dili) {
            this.hot = hot;
            this.dili = dili;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, T;
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        NoonFood[] noonFoods = new NoonFood[N];
        NightFood[] nightFoods = new NightFood[M];
        int MinHot = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            noonFoods[i] = new NoonFood(sc.nextInt(), sc.nextInt());
            if (noonFoods[i].dili >= T) {
                MinHot = Math.min(MinHot, noonFoods[i].hot);
            }
        }
        for (int i = 0; i < M; i++) {
            nightFoods[i] = new NightFood(sc.nextInt(), sc.nextInt());
            if (nightFoods[i].dili >= T) {
                MinHot = Math.min(MinHot, nightFoods[i].hot);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(noonFoods[i].dili+nightFoods[j].dili>=T){
                    MinHot=Math.min(MinHot, noonFoods[i].hot+ nightFoods[j].hot);
                }
            }
        }
        if (T == 0) {
            System.out.println(0);
        } else {
            if(MinHot==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(MinHot);
            }
        }
    }
}
