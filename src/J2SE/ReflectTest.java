package J2SE;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c=Class.forName("J2SE.Student");
        Constructor con=c.getConstructor(int.class,String.class);
        Object o=con.newInstance(3,"xiaoming");
        Student s=(Student)o;
        System.out.println(s.getName());
//        System.out.println(con);
    }



}
