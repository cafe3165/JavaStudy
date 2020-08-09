package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Author:cafe3165
 * Date:2020-08-08
 */
public class wangyi_2 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool= ForkJoinPool.commonPool();
        Scanner sc = new Scanner(System.in);
//        5 3
//        2 1 5
        int n = sc.nextInt(), m = sc.nextInt();
        int[] T = new int[m];
        boolean[] num = new boolean[n + 1];
        num[0] = true;
        for (int i = 0; i < m; i++) {
            T[i] = sc.nextInt();
            num[T[i]] = true;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num.length ; i++) {
            if (!num[i]) {
                numList.add(i);
            }
        }

        int[] res = new int[n];
        int idRes = 0, idT = 0, idNum = 0;
        for (int i = 0; i < n && idT < T.length && idNum < numList.size(); i++) {
            if (T[idT] < numList.get(idNum)) {
                res[idRes++] = T[idT];
                idT++;
            } else {
                res[idRes++] = numList.get(idNum);
                idNum++;
            }
        }
        if(idT<T.length){
            while(idT<T.length){
                res[idRes++]=T[idT++];
            }
        }
        if(idNum<numList.size()){
            while(idNum<numList.size()){
                res[idRes++]=numList.get(idNum++);
            }
        }


        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[idRes - 1]);
    }
}
