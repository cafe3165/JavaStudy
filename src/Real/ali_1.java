package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-08-10
 */
public class ali_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] trees = new int[N];
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <N; i++) {
            trees[i]=in.nextInt();
            set.add(trees[i]);
        }
        Arrays.sort(trees);
        long res=Integer.MAX_VALUE;
        int mid=(N+1)/2;
        if (!set.contains(trees[mid])){
            res=dis(mid,trees);
        }else{
            int tmp=mid;
            while(set.contains(trees[mid])){
                mid++;
            }
            res=Math.min(res,dis(mid,trees));
            while(set.contains(trees[tmp])){
                tmp--;
            }
            res=Math.min(res,dis(tmp,trees));
        }


        System.out.println(res);
    }

    public static long dis(int mid,int[] trees){
        long res=0;
        for (int i = 0; i < mid; i++) {
            res+=trees[mid]-trees[i];
        }
        for (int i = mid+1; i < trees.length ; i++) {
            res+=trees[i]-trees[mid];
        }
        return res;
    }



}
