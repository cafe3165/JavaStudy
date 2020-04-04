package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
public class Single {
    private volatile static Single uniqueinstance;

    private Single() {

    }

    public static Single getInstance() {
        if (uniqueinstance == null) {
            synchronized (Single.class) {
                if (uniqueinstance == null) {
                    uniqueinstance = new Single();
                }
            }
        }
        return uniqueinstance;

    }


    public static void main(String[] args) {


    }
}
