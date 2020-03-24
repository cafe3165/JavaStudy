package J2SE;

import com.google.common.hash.HashCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class hashcodeTest {

    public int a;
    public int b;

    public void setA(int a) {
        this.a = a;
    }

    public hashcodeTest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof hashcodeTest)) {
            return false;
        }
        hashcodeTest that = (hashcodeTest) o;
        return a == that.a &&
                b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash( b);
    }

    public static void main(String[] args) {

        HashMap<hashcodeTest, String> test = new HashMap<>();
        hashcodeTest h1=new hashcodeTest(1,2);
        hashcodeTest h2=new hashcodeTest(3,4);
        test.put(h1,"A");
        test.put(h2,"B");
        System.out.println(test.get(new hashcodeTest(1,2)));
        h1.setA(4);
        System.out.println(test.get(h1));
        System.out.println(test.get(new hashcodeTest(4,2)));

    }
}
