package Real;


import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class Real360_1 {
    public static class people {
        public int num;
        public int atk;
        public int game;

        public people(int num, int atk) {
            this.num = num;
            this.atk = atk;
            game = 0;
        }
    }

    public static int[] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        people[] ps = new people[n];
        max = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            ps[i] = new people(i, tmp);
            max[i] = tmp;

        }

        solve(n, m, ps);
//        4 3 1 3 2 4
    }

    private static void solve(int n, int m, people[] ps) {
        int res = 0;
        if(m>=n){
        for (int i = 0; i < n; i++) {
            if (ps[i].atk == max[n - 1]) {
                break;
            }
            res++;
        }
        res += m;
        }
        else{
            while (true) {
                people p1 = ps[0];
                people p2 = ps[1];
                if (p1.game == m) {
                    break;
                } else {
                    if (p1.atk > p2.atk) {
                        p1.game++;
                        for (int i = 1; i < ps.length - 1; i++) {
                            ps[i] = ps[i + 1];
                        }
                        ps[ps.length - 1] = p2;
                    } else {
                        p2.game++;
                        ps[0] = p2;
                        for (int i = 1; i < ps.length - 1; i++) {
                            ps[i] = ps[i + 1];
                        }
                        ps[ps.length - 1] = p1;
                    }

                    res++;
                }
            }
        }


        System.out.println(res);
    }
}
