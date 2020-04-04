package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-04
 */
public class neteaseExercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        aaabbaaac
        char[] chs = str.toCharArray();
        Map<String, Integer> m = new HashMap<>();
        String tmp = "" + chs[0];
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == tmp.charAt(0)) {
                tmp += chs[i];
            } else {
                int count = m.getOrDefault(tmp, 0);
                m.put(tmp, count + 1);
                tmp = "" + chs[i];
            }
        }

        m.put(tmp, m.getOrDefault(tmp, 0) + 1);
        double sum = 0.0;
        int c = 0;
        for (String i :
                m.keySet()) {
            sum += (m.get(i)*i.length());
            c+=m.get(i);
        }
        System.out.println(sum / c);

    }
}
