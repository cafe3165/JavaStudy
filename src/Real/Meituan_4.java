package Real;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class Meituan_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        Arrays.sort(array);

        List<int[]> plist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] pair = new int[2];
                pair[0] = i;
                pair[1] = j;
                plist.add(pair);
            }
        }
        long res=0;
        for (int[] p:plist) {
            long tmp=array[p[0]]^array[p[1]];
            res^=tmp;
        }
        System.out.println(res);

    }
}
