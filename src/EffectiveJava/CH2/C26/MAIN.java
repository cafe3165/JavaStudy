package EffectiveJava.CH2.C26;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/7 1:05 下午
 */
public class MAIN {
    public static int collectionInCommonNum(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("111");
        s1.add("222");
        Set<String> s2 = new HashSet<>();
        s2.add("111");
        Set<Integer> s11 = new HashSet<>();
        Set<Integer> s22 = new HashSet<>();
        s11.add(new Integer(1));
        s22.add(new Integer(1));
        int res = collectionInCommonNum(s1, s22);
        System.out.println(res);
    }
}
