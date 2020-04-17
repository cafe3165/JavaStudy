package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class meituan04161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int l=a.size();
        Collections.sort(a);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) == k) {
                index = i;
                break;
            }
        }
        int res = 0;
        int mid = (l + 1) / 2-1;
        if (a.get(index) < a.get(mid)) {
            while (true) {
                int tmp1 = ((res + l + 1) / 2) - 1;
                int tmp2 = res + index;
                if (tmp1 == tmp2) {
                    System.out.println(res);
                    break;
                }
                res++;
            }
        } else {
            while (true) {
                int tmp1 = (res + l + 1) / 2 - 1;
                int tmp2 = index;
                if (tmp1 == tmp2) {
                    System.out.println(res);
                    break;
                }
                res++;
            }
        }
    }
}
