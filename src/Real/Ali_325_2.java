package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-25
 */
public class Ali_325_2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] query = new int[q][2];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2; j++) {
                query[i][j] = sc.nextInt();
            }
        }

        int[] del = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp1 = 0, tmp2 = Integer.MAX_VALUE-100;
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0 && tmp1 >= tmp2) {
                    tmp1 = a[i][j];
                }
                if (a[i][j] > tmp1) {
                    tmp2 = a[i][j];
                    break;
                }
            }
            del[i] = tmp2 - tmp1<0?tmp1-tmp2:tmp2-tmp1;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
              if(a[i][j]!=0){
                  int low=j,high=j;
                  while(low>0){
                        a[i][low-1]=a[i][low]-del[i];
                        low--;
                  }
                  while(high<m-1){
                      a[i][high+1]=a[i][high]+del[i];
                      high++;
                  }
                  break;
              }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
////                System.out.print(a[i][j]);
//            }
//        };

        for (int i = 0; i < q; i++) {
            int I=query[i][0]-1,J=query[i][1]-1;
            if(a[I][J]==0){
                System.out.println("Unknown");
            }else{
                System.out.println(a[I][J]);
            }

        }
//        for (int i = 0; i < ; i++) {
//
//        }

    }
}
