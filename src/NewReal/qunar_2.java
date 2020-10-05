package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-23
 */
public class qunar_2 {
    static class Plane {
        String name;
        int no;

        public Plane(String name, int no) {
            this.name = name;
            this.no = no;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Plane> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            map.put(name, new Plane(name, i));
        }

        int res = 0;
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            List<Plane> planeList = new ArrayList<>();
            for (int j = i; j < n; j++) {
                String name = names[j];
                Plane p = map.get(name);
                if (isValid(planeList, p)) {
                    planeList.add(p);
                }
            }
            res = Math.max(res, planeList.size());
        }
        System.out.println(res);
    }

    private static boolean isValid(List<Plane> planeList, Plane p) {
        for (int i = 0; i < planeList.size(); i++) {
            if (planeList.get(i).no > p.no) {
                return false;
            }
        }
        return true;
    }
}
