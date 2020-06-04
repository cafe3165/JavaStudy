package leetcode_daily.May;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-23
 */
public class T76minWindow {
    static Map<Character, Integer> ori = new HashMap<>();
    static Map<Character, Integer> cnt = new HashMap<>();


    public static String minWindow(String s, String t) {
        char[] tchs = t.toCharArray();
        int tlen = tchs.length;
        for (int i = 0; i < tlen; i++) {
            ori.put(tchs[i], ori.getOrDefault(tchs[i], 0) + 1);
        }

        int l = 0, r = -1;
        int slen = s.length(), reslen = Integer.MAX_VALUE;
        int resL = -1, resR = -1;
        while (r < slen) {
            ++r;
            if (r < slen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < reslen) {
                    reslen = r - l + 1;
                    resL = l;
                    resR = l + reslen;
                }

                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;

            }
        }

        return resL == -1 ? "" : s.substring(resL, resR);
    }

    static boolean check() {
        Iterator it = ori.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        String S = "ABAACBAB", T = "ABC";
//       String res= minWindow(S, T);
        System.out.println(S.substring(1, 5));

    }
}
