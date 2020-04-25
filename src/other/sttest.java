package other;

/**
 * Author:cafe3165
 * Date:2020-04-14
 */
public class sttest {
    public static final String INC = "perworld";

    public static void main(String[] args) {
        String a = "per" + "world";
        String b = "perworld";
        String c = "world";
        System.out.println(a==INC);
        System.out.println((b+c)==INC);
    }
}
