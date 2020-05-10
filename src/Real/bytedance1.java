package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class bytedance1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[] arr = new long[n];
        List<Long> five = new ArrayList<>();
        List<Long> two = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] % 5 == 0) {
                five.add(arr[i]);
                continue;
            }
            if (arr[i] % 2 == 0) {
                two.add(arr[i]);
            }
        }
        Collections.sort(five, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return countFive(o2) - countFive(o1);
            }

            //对能被5整除的次数从大到小进行排序，能被5整除越多次，就能获得越多的0
            public int countFive(long o) {
                int count = 0;
                while (o % 5 == 0) {
                    count++;
                    o /= 5;
                }
                return count;
            }
        });
        //
        Collections.sort(two, (o1, o2) -> (int) (o2.longValue() - o1.longValue()));
        long tmpres = 1;
        int count = 0, index = 0;
        while (index < five.size() && count < k - 1) {
            tmpres *= five.get(index++);
            count++;
        }
        index = 0;
        while (index < two.size() && count < k) {
            tmpres *= two.get(index++);
            count++;
        }
        if(count<k&&count<five.size()){
            tmpres*=five.get(count++);
        }

        System.out.println(countZero(tmpres));
    }

//  5 3 15 16 3 25 9
//        5 2 50 555 2 2 2
// 5 2 50 50 50 50 50
//    5 2 2 2 2 2 2
    //5 3  5  7 9 11 13

    public static int countZero(long a) {
        int w = 10;
        int res = 0;
        while (a % w == 0) {
            res++;
            w *= 10;
        }
        return res;
    }


}
