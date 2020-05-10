package J2SE;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class trycatchtest {
    public static int trytest(int n) {
        try {
            n = 2/0;
            int c=100;
            int[] a=new int[1];
            System.out.println(a[c]);
            return n;
        } catch (Exception e) {
//            e.printStackTrace();
            e.getMessage();
        } finally {
            n = 5;
        }
        return n-1;
    }

    public static void main(String[] args) {
//        int res = trytest(1);
//        System.out.println(res);
          String str =null;

        System.out.println("test exception");
        try {
            if(str.equals("name")){
                System.out.println("test exception");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }


}
