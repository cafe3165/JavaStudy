package J2SE.single;

/**
 * Author:cafe3165
 * Date:2020-09-07
 */
public class Singleton2 {
    private static Singleton2 uniqueInstance;

    private Singleton2() {
    }

    public static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
