package J2SE;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
public class TreeSetTest {


    public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet();

        /*
         * 以Person对象年龄进行从小到大的排序。
         *
         */


        ts.add(new Person("lisi", 21));
        ts.add(new Person("zhangsan", 28));

        ts.add(new Person("zhaoliu", 25));
        ts.add(new Person("zhouqi", 29));
        ts.add(new Person("wangu", 24));

        Iterator it = ts.iterator();

        while (it.hasNext()) {
            Person p = (Person) it.next();

            System.out.println(p.getName() + ":" + p.getAge());
        }
    }


}
