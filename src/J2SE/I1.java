package J2SE;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public interface I1 {
    default public void A() {
        System.out.println("I1");
    }

    public void B();
}
