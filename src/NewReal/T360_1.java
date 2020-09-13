package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-11
 */
public class T360_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            set.add(a);
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                res.add(i);
            }
        }


        if(set.size()==1){
            Iterator it=set.iterator();
            while(it.hasNext()){
                res.add((Integer)it.next());
            }
        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            if(i<res.size()-1){
                System.out.print(res.get(i)+" ");
            }else{
                System.out.print(res.get(i));
            }
        }

    }
}
