package com.example.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2023-02-05
 */
public class ChangableArgsTest {

    public void test(String name, Integer... ages) {

    }

    public static void main(String[] args) {
//
//        Integer a = 127;
//        int c = 127;
//        Integer b = new Integer(127);
//        Integer d = new Integer(127);
//        System.out.println(a == b);  // false
//        System.out.println(a.hashCode());
//        System.out.println(d.hashCode());
//        System.out.println(a == c);
//        System.out.println(a.equals(b));
//        System.out.println(Objects.equals(a, b));
//
//        System.out.println(b == d);
//
//        String str = "start";
//        for (int i = 0; i < 100; i++) {
//            str = str + "hello";
//        }

        List<String> aList = new ArrayList<>();
        aList.add("a");
        aList.add("b");
        aList.add("c");
        aList.add("d");
        System.out.println(aList.size());
        List<String> bList = new ArrayList<>(aList.subList(0, 2));
        System.out.println(bList.size());
        bList.remove(1);
        System.out.println(aList.size());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
//            if (删除元素的条件) {
                iterator.remove();
//            }
        }

        Person person = new Person();
        person.setName("xiaoming");
        changeName(person);
        System.out.println(person.getName());
    }

    private static void changeName(Person person) {
        person.setName("daming");
    }


    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
