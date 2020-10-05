package GeekBang.Concurrent;

/**
 * Author:cafe3165
 * Date:2020-09-14
 */
public class Test2 {

    class SafeCalc {
        long value = 0L;

        long get() {
            synchronized (new Object()) {
                return value;
            }
        }

        void addOne() {
            synchronized (new Object()) {
                value += 1;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();


        System.out.println(sb.length());
        sb.append("1");
        sb.append("1sdf5464f56sa4f56s4af564sa56f465s4f564s56f4s5a64f56sa4f56sa4f56s4f56s4d65f");



    }
}
