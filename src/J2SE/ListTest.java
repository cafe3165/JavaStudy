package J2SE;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import  java.util.Collections;
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

        Hashtable<String ,Integer> ht=new Hashtable<>();
//        ConcurrentHashMap

//        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
//        list.get()
        List<Integer> list=new ArrayList<>();
//        List<Integer> safeList=
        List<Integer> safelist= Collections.synchronizedList(new ArrayList<>());
    }
}
