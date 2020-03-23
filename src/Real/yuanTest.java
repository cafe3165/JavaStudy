package Real;

import com.google.common.primitives.UnsignedInteger;

/**
 * Author:cafe3165
 * Date:2020-03-20
 */
public class yuanTest {
    public static int fun1(int i) {
        return i < 2 ? i : fun1(i - 1) + fun1(i - 2);
    }

    public static int  fun2(int i) {
        int j =  i & 0xFFFF;
        return (int)((j & 0x9108) ^ (j & 0x8019));
    }

    public static void main(String[] args) {
        int n = fun2(fun1(101)) % 4;
        System.out.println(n);

    }
}
