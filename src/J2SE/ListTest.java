package J2SE;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class ListTest<T> {
    public T tt;
    public T  t(T tt){
        this.tt=tt;
        return tt;
    }




    public static void main(String[] args) {
//        List<String> l1=new ArrayList<Object>();
//        List<Object> l2=new ArrayList<String>();
////        l1=l2;
        ListTest<String> l1=new ListTest<>();
        ListTest<Integer> l2=new ListTest<>();
        System.out.println(l1.t("tttt"));
        System.out.println(l2.t(666));


    }
}
