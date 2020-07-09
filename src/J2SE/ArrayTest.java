package J2SE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class ArrayTest {
    public ArrayTest() {

    }

    public void ArrayTest(int i) {
        System.out.println(i);
    }

    //    static{
//        System.out.println("6666");
//    }
    public static int test() {
        int a;
        Integer b;
        try {
            a = 1;
            b=2;
            System.out.println(a);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("final");
            a=2;
            b=3;
            return b;
    }
    }

    public static void main(String[] args) {
//        float[] fa=new float[10];
//        System.out.println(fa[9]);
//        ArrayTest a=new ArrayTest();
//        a.ArrayTest(9);

//        System.out.println(test());
        int[] a={0,1,2,3,4,5};
        int[] b=new int[5];
        System.arraycopy(a,1,b,0,3);
        System.out.println(b);
        int[] c= Arrays.copyOf(a,4);
        System.out.println(c);
    }
}
