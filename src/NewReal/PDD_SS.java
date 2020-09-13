package NewReal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:cafe3165
 * Date:2020-09-11
 */
public class PDD_SS {
    public static void main(String[] args) {
        List<String> sl = new ArrayList<>();
        sl.add("a");
        sl.add("0");
        sl.add("abc");
        sl.add("nn");
        Collections.sort(sl, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        print(sl);
        String[] sl2 = {"a", "0", "abc", "nn"};

        for (int i = 0; i < sl2.length;i++) {
            System.out.println(sl2[i]);
        }

    }

    public static void print(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
