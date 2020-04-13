package J2SE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class TTest<T, U> {
    T name;
    U age;

    public TTest(T name, U age) {
        this.age = age;
        this.name = name;

    }

    public static void main(String[] args) {
        TTest<String, Integer> t = new TTest<>("iii",4);
        Optional<String> o= Optional.empty();

        List<Integer> l=new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(1,5);

        Iterator i= l.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
