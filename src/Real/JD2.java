package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-18
 */
public class JD2 {
    public static class pair {
        public int l;
        public int w;

        public pair(int l, int w) {
            this.l = l;
            this.w = w;
        }
    }

    public static boolean solve(List<pair> list) {
        Collections.sort(list, (o1, o2) -> o1.l - o2.l);
        Collections.sort(list, (o1, o2) -> o1.w - o2.w);
        for (int i = 0; i < 6; i++) {
            if(list.get(i).l<=0||list.get(i).w<=0){
                return false;
            }
        }

        if (list.get(0).l != list.get(1).l || list.get(0).w != list.get(1).w) {
            return false;
        }
        int w1 = list.get(0).w;
        if (list.get(2).l != list.get(3).l || list.get(2).w != list.get(3).w) {
            return false;
        }
        if(list.get(0).l !=list.get(2).l){
            return false;
        }
        int l1 = list.get(2).w;
        if (list.get(4).l != list.get(5).l || list.get(4).w != list.get(5).w) {
            return false;
        }
        if (l1 > w1) {
            int tmp = l1;
            l1 = w1;
            w1 = tmp;
        }
        if (list.get(4).l!=l1||list.get(4).w!=w1){
            return false;
        }
            return true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<pair>> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            List<pair> tmp = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                int l = in.nextInt(), w = in.nextInt();
                if (l > w) {
                    tmp.add(new pair(w, l));
                } else {
                    tmp.add(new pair(l, w));
                }
            }
            list.add(tmp);
        }
        boolean res;
        for (int i = 0; i < n; i++) {
            res = solve(list.get(i));
            System.out.println(String.valueOf(res ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }

}
