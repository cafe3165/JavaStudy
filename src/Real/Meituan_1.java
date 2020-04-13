package Real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class Meituan_1 {

    public static void solve(int[] array, int x) {
        Arrays.sort(array);
        int res = 0;
        int index_i = 0, index_j = 0;

        while (index_j < array.length - 1) {
            index_j++;
            while (index_i < index_j && array[index_j] - array[index_i] > x) {
                ++index_i;

            }
//            以 j为最大，i为最小，共有多少个符合的
            res = Math.max(index_j - index_i + 1, res);
        }
//        while (array[index_j] - array[index_i] > x && index_j-index_i>1) {
////            int Max = Math.max(array[index_j] - array[index_j - 1], array[index_i + 1] - array[index_i]);
////            if (Max == array[index_i + 1] - array[index_i]) {
////                ++index_i;
////                ++res;
////            } else {
////                --index_j;
////                ++res;
////            }
//
//            ++res;
//            if(array[index_j]-array[index_i+1]>array[index_j-1]-array[index_i]){
//                --index_j;
//            }else{
//                ++index_i;
//            }
//        }
//
//        if(array[index_j]-array[index_i]>x&&index_j-index_i==1){
//            res+=2;
//        }
//        if(array[index_j]-array[index_i]>x&&index_j-index_i==0){
//            ++res;
//        }

        System.out.println(array.length - res);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
//        5 2
//        2 1 3 2 5
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        solve(array, x);
    }
}
