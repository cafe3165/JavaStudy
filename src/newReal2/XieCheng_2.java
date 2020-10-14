package newReal2;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-10-13
 */
public class XieCheng_2 {
    static class Driver {
        int a;
        int b;
        int d;

        public Driver(int a, int b) {
            this.a = a;
            this.b = b;
            d = a - b;
        }
    }
    public static boolean isNum(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Driver> driverList = new ArrayList<>();
        boolean f = true;
        while (true) {
            String s = sc.next();
            if ("#".equals(s)) {
                break;
            }
            String r = sc.next();
            if(!isNum(s)||!isNum(r)){
                f=false;
                break;
            }
            int a = Integer.parseInt(s), b = Integer.parseInt(r);
            if (a < 1 || a > 1000 || b < 1 || b > 1000) {
                f = false;
                break;
            }
            driverList.add(new Driver(a, b));
        }
        int count = driverList.size();
        Collections.sort(driverList, new Comparator<Driver>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                if (o1.d == o2.d) {
                    return o2.a - o1.a;
                }

                return o2.d - o1.d;
            }
        });
        int sum = 0;
        for (int i = 0; i < count / 2; i++) {
            Driver driver = driverList.get(i);
            sum += driver.a;
        }
        for (int i = count / 2; i < count; i++) {
            Driver driver = driverList.get(i);
            sum += driver.b;
        }
        if (f) {
            System.out.println(sum);
        } else {
            System.out.println("error");
        }
    }
}
