package J2SE.jvm.finalize;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class FinalizationDemo {


    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);
        c2 = c3 = null;
        System.gc();
    }
}
