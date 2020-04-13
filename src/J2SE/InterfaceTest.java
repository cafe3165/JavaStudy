package J2SE;

import java.sql.SQLOutput;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class InterfaceTest implements I1 {
    @Override
    public void A() {
        System.out.println("5555");
    }

    @Override
    public void B() {

    }

    public static void main(String[] args) {
//        I1 interfaceTest=new InterfaceTest();
//        interfaceTest.A();
        MyLamda m = y -> System.out.println("ss" + y);
    }
}
