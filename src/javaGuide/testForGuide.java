package javaGuide;

import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class testForGuide {
    public static void main(String[] args) {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
//上面两个语句等价于下面一条语句
        System.out.println(myList);
//        myArray[0]="xxx";
//        System.out.println(myList);
        List list = new ArrayList<>(Arrays.asList(myArray));
        list.add("xxx");
        System.out.println(list);
//        myList.add("xxx");
//        System.out.println(myArray);
//        List<String> myList = Arrays.asList("Apple","Banana", "Orange");


        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        Iterator<String> it = l.iterator();
//        while (it.hasNext()) {
//            String item = it.next();
//            if ("2".equals(item)) {
//                it.remove();
//            }
//        }

        for (String item :
                l) {
            if ("2".equals(item)) {
                l.remove(item);
            }
        }


        System.out.println(l);
        System.out.println(l);
    }
}
