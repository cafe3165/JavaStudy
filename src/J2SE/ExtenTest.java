package J2SE;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-09-19
 */
public class ExtenTest {
    public static void main(String[] args) {
//        a A=new a();
//        System.out.println(A.getI());
//        b B=new b();
//        System.out.println(B.getI());
//        a AB=new b();
//        System.out.println(AB.getI());
        Map<Integer, Integer> map=new HashMap<>();
        map.put(null,2);
        map.put(null,null);
        map.put(2,null);
        System.out.println(map.get(null));
    }
}

class a {
    int i = 0;

    public a() {

    }

    public int getI() {
        return i;
    }
}

class b extends a {
    @Override
    public int getI() {
        return 1;
    }
}
