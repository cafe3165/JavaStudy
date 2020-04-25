package J2SE;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class trycatchtest {
    public static int trytest(int n) {
        try {
            n = 2;
            return n;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            n = 3;
        }
        return n-1;
    }

    public static void main(String[] args) {
        int res = trytest(1);
        System.out.println(res);
    }


}
