package NewReal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-21
 */
public class DIDI_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[][] FibMatric = new Long[n][n];
        List<Long> resList=Fibonacci(n*n);
        spiralOrder(FibMatric,resList);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j<n-1) {
                    System.out.print(FibMatric[i][j]+" ");
                }else{
                    System.out.println(FibMatric[i][j]);
                }
            }
        }
    }

    public static void spiralOrder(Long[][] matrix,List<Long> resList) {
        int index=resList.size()-1;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i]=resList.get(index--);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                matrix[i][right]=resList.get(index--);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                matrix[down][i]=resList.get(index--);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                matrix[i][left]=resList.get(index--);
            }
            if (++left > right) {
                break;
            }
        }
    }

    public static List<Long> Fibonacci(int n) {
        List<Long> resList = new ArrayList<>();
        long f = 0;
        long g = 1;
        long res = f + g;
        resList.add(res);
        for (int i = 2; i <= n; i++) {
            res = f + g;
            f = g;
            g = res;
            resList.add(res);
        }

        return resList;
    }
}
