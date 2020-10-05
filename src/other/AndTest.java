package other;

/**
 * Author:cafe3165
 * Date:2020-09-26
 */
public class AndTest {
    public static void main(String[] args) {
        long t1=System.currentTimeMillis();
        for (long i = 0; i < 10000000000l; i++) {
            if (i % 2 == 0) {

            }
        }
        System.out.println(System.currentTimeMillis()-t1);

        System.out.println("---------------------------------------");
        long t3 = System.currentTimeMillis();
        for (long i = 0; i < 10000000000l; i++) {
            if ((i & 1) == 0) {

            }
        }
        System.out.println(System.currentTimeMillis() - t3);
    }
}
