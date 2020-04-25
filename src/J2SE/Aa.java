package J2SE;

import javafx.beans.binding.StringBinding;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class Aa implements A{
    public final StringBuilder sb=new StringBuilder("666");


    public static void main(String[] args) {
//        A a=new Aa();
//        a.say();
//        Aa aa=new Aa();
//        System.out.println(aa.sb);
//        aa.sb.append("7");
//        System.out.println(aa.sb);

//        String a=new String("01234567");
////        String aa=a.intern();
////        String b=new String("abc");
////        String bb=b.intern();
////        String c="abc";
////        StringBuilder s;
////        System.out.println(aa==c);
//        String sub=a.substring(3,5);
//        System.out.println(sub);
        int[] a={1,2,3,4};
        Integer[] b={1,2,3,4};
//        a=b;


    }

    @Override
    public void say() {
        System.out.println(8888);
    }
}
