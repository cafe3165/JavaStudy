package other;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-04-04
 */


public class hashmaptest {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    //    public static int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
    public static void main(String[] args) {

        int h;
        String s="666";
        System.out.println((h=s.hashCode())^(h>>>16));
//        HashMap

    }
}
