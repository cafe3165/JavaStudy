package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class Meituan_2 {
    public static void solve(int[] room,int n,long m,long SUM,int MIN){
        int res = 0;
        while (m >= SUM) {
            long tmp=m/SUM;
            m%=SUM;
            res+=(tmp*n);
//            m -= SUM;
//            res += n;
        }
        int index_i = 0;
        while (m >= MIN) {
            if (m >= room[index_i]) {
                ++res;
                m -= room[index_i];
            }
            index_i = (++index_i) % n;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int room[] = new int[n];
        long SUM = 0;
        int MIN = Integer.MAX_VALUE - 1;
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextInt();
            MIN = Math.min(MIN, room[i]);
            SUM += room[i];
        }
        solve(room,n,m,SUM,MIN);



    }

}
