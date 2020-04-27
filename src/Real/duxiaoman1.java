package Real;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class duxiaoman1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int[] city = new int[N];
        Set<Integer> close = new HashSet<>();
        Set<Integer> open = new HashSet<>();
        for (int i = 0; i < N; i++) {
            city[i] = sc.nextInt();
            open.add(i + 1);
        }
        long[] shorest = new long[N];
        for (int i = 0; i < N; i++) {
            shorest[i] = A + C * (N - city[i]);
        }
        open.remove(N);
        close.add(N);
        shorest[N - 1] = 0;
        while (!close.contains(1)) {
            long min = Long.MAX_VALUE;
            for (Integer cl : close) {
                for (Integer op : open) {
                    if (city[op - 1] == cl) {
                        shorest[op - 1] = Math.min(shorest[cl - 1] + A, shorest[op] - 1);
                    } else if (city[op - 1] < cl) {
                        shorest[op - 1] = Math.min(shorest[cl - 1] + (cl - city[op - 1]) * C + A, shorest[op - 1]);
                    } else {
                        shorest[op - 1] = Math.min(shorest[cl - 1] + (city[op - 1] - cl) * B + A, shorest[op - 1]);
                    }
                    min = Math.min(min, shorest[op - 1]);

                }
            }
            close.clear();
            Iterator<Integer> iterator=open.iterator();
            while (iterator.hasNext()){
                Integer in = iterator.next();
                if (shorest[in-1] == min){
                    close.add(in);
                    iterator.remove();
                }
            }


        }


//7 1 1 1 3 6 4 3 4 5 6


    }
}
