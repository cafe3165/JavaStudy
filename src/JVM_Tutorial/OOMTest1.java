package JVM_Tutorial;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-11
 */
public class OOMTest1 {
    static class OOMObject {

    }

    public static void main(String[] args) {
//        String str="aa"+"bb"+" "+"cc";
//        List<OOMObject> list = new ArrayList<>();
//        while (true) {
//            list.add(new OOMObject());
//        }

        int a=1;
        Integer b=new Integer(1);
        Integer c=new Integer(1);
        System.out.println(a==(b+c) );
        System.out.println(b.equals(c));


    }

}
