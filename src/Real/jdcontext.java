package Real;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class jdcontext {
    public static void main(String[] args) {
        int[] array={1,2,3};
        int res=1;
        for (int i = 0; i < array.length; i++) {
            res&=array[i];
        }
        System.out.println(res);
    }
}
