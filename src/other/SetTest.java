package other;

import java.sql.DriverManager;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Author:cafe3165
 * Date:2020-06-15
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p = new Person(5, "cafe", "male");
        Person q = new Person(6, "more", "female");
        set.add(p);
        set.add(q);
        set.remove(p);
        Iterator<Person> it = set.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getId() == 6) {
                it.remove();
                break;
            }
        }

//        LinkedList
//        Stack
//        ArrayDeque
//        LinkedBlockingDeque
//        DriverManager
//            Deque<
//            Integer> deque=new ArrayDeque<>();
//        deque.addLast();
//        deque.
    }
}
