package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-07
 */
public class nete2 {
    public static void solve(List<monstor> mons,int n,int res,int D) {
        for (int i = 0; i < n; i++) {
            if (mons.get(i).a > D) {
                res -= mons.get(i).b;
            }else{
                D++;
            }
        }
        System.out.println(-res);

    }

    public static class monstor {
        public int a;
        public int b;


        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n = sc.nextInt(), D = sc.nextInt();
        List<monstor> mons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monstor m = new monstor();
            m.setA(sc.nextInt());
            mons.add(m);
        }
        for (int i = 0; i < n; i++) {
            monstor tmp = mons.get(i);
            tmp.setB(sc.nextInt());
        }

        Collections.sort(mons, new Comparator<monstor>() {
            @Override
            public int compare(monstor o1, monstor o2) {
                if(o1.a==o2.a){
                    return o1.b-o2.b;
                }
                return o1.a - o2.a;
            }
        });

//        Collections.sort(mons,new C);


        solve(mons,n,res,D);
    }
}
