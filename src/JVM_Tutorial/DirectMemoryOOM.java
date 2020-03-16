package JVM_Tutorial;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Author:cafe3165
 * Date:2020-03-12
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe=(Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
