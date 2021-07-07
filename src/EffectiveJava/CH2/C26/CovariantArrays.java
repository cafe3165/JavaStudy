package EffectiveJava.CH2.C26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/7 1:13 下午
 */
public class CovariantArrays {
    public static void main(String[] args) {
//        Fruit[] fruit = new Apple[10];
//        fruit[0] = new Apple(); // OK
//        fruit[1] = new Jonathan(); // OK
//        // Runtime type is Apple[], not Fruit[] or Orange[]:
//        try {
//            // Compiler allows you to add Fruit:
//            fruit[0] = new Fruit(); // ArrayStoreException
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        try {
//            // Compiler allows you to add Oranges:
//            fruit[0] = new Orange(); // ArrayStoreException
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        // ArrayList<Fruit> flist = new ArrayList<Apple>();
//       ss.add();

//        fruits.contains()
//        fruits.add()
//       PECS 原则
//        Producer Extens Consumer Supers
        List<Fruit> fruits = new ArrayList<>();


    }
//    public static <? extends Fruit>  get(List<? extends Fruit> list) {

//    }


    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++) {
            dest.set(i,src.get(i));
        }
    }


}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

