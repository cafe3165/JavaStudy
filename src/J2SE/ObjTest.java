package J2SE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class ObjTest {
    public int a;


    public ObjTest(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        ObjTest o1=new ObjTest(1);
        ObjTest o2=new ObjTest(1);
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
//        List<Integer> l1 = Arrays.asList(new Integer[]{1, 2, 3});
//        List<Integer> l2 = Arrays.asList(new Integer[]{1, 2, 3});

//        System.out.println(l1.hashCode());
//        System.out.println(l2.hashCode());



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof ObjTest)) {return false;}
        ObjTest objTest = (ObjTest) o;
        return a == objTest.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
