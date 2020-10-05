package J2SE;

/**
 * Author:cafe3165
 * Date:2020-09-27
 */
public class TryTest {
    static int n = 0;

    private static void foo() {
        System.out.println(n++);
        try{
            System.out.println("try");
            System.exit(1);
            //foo();
        }catch (Throwable e){
            System.out.println("catch");
            //foo();
        }finally {
            System.out.println("finally");
            //foo();
        }
    }

    public static void main(String[] args) {
        foo();
    }

}
