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
//        Integer[] aa = {3, 2, 23, 543, 2, 3, 1};
//        List<Integer>l=new ArrayList<>();
//      Collections.addAll(l,aa);
//      Collections.sort(l,(a,b)->b-a);
//      Collections.rotate(l,-3);
//        System.out.println(l);
//        String a = "abc";
////        byte[] aa=a.getBytes();
//        StringBuffer sb = new StringBuffer("abc");
//        System.out.println(a.contentEquals(sb));
//        char[] aa = {'s', 's'};
//        System.out.println(aa.length);

//        String b=null;
//        if(b.equals("")||b==null){
//            System.out.println("666");
//        }
//        String s="Sfdsfsdf.sdfsdfsd.sdfsdfsd";
//        String[] ss=s.split("\\.");
//        for (String str : ss) {
//            System.out.println(str);
//        }
//        String s = null;
////        if ((s!=null) | (s.length()==0)) {
////
////        }
//        if((s!=null)&(s.length()==0)){
//
//        }
        solve(5);

    }

    public static int solve(int n) {
        Set<Integer> set = new HashSet<>();
        int[] score = {0, 1, 3};
        int[] count = {0, 0, 0};
        int s = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = j; k < 3; k++) {
                    count[j] += score[k];
                    set.add(count[j]);
                }
                // set.add(s);
            }
        }

//        for (int i = 0; i < 3; i++) {
//            s = score[i];
//            for (int j = 0; j < n - 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    s += score[k];
//                    set.add(s);
//                }
//            }
//        }
        return set.size();
    }


}
