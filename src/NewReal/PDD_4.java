package NewReal;

import other.bs;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-01
 */
public class PDD_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<Integer> feature = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            feature.add(sc.nextInt());
        }

        Collections.sort(feature, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < feature.get(j)) {
                    break;
                }
                if (i % feature.get(j) == 0) {
                    set.add(i);
                    break;
                }
            }
        }
        System.out.println(set.size());
    }
}
