package other;


import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-07
 */
public class Stringtest {
    public static void main(String[] args) {
//        String str=new String("abc");
//        System.out.println(str);
        Integer[] aa = {3, 2, 23, 543, 2, 3, 1};
        List<Integer>l=new ArrayList<>();
      Collections.addAll(l,aa);
      Collections.sort(l,(a,b)->b-a);
      Collections.rotate(l,-3);
        System.out.println(l);

    }
}
