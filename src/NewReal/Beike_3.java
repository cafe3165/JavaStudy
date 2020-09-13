package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-07
 */
public class Beike_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mon = new int[2 * n];
        int[] pri = new int[2 * n];
        int res = 0;
        for (int i = 0; i < 2 * n; i++) {
            mon[i] = sc.nextInt();
        }
        for (int i = 0; i < 2 * n; i++) {
            pri[i] = sc.nextInt();
        }
        int[] blood = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            blood[i] = pri[i] - mon[i];
        }
        for (int i = 0; i < 2 * n; i++) {
            res += blood[i];
        }
        int left = mon[n - 1];
        int right = mon[n];
        res = res * (-1) + 1;
        int min=Math.min(left,right);
        if (res>min){
            System.out.println(res);
        }else{
            System.out.println(min+1);
        }


    }
}
