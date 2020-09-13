package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-07
 */
public class Beike_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s=sc.next();
        int maxLen=1;
        for (int i = 0; i < n; i++) {
            String sub=s.substring(0,i+1);
            if(i>n/2+1){
                break;
            }
            if(2*i+2<=n){
                String sub2=s.substring(i+1,2*i+2);
                if(jude(sub,sub2)){
                    maxLen=Math.max(maxLen,sub.length());
                }
            }
        }
        System.out.println(s.length()-maxLen+1);

    }
    public static boolean jude(String a,String b){
        if(a.equals(b)){
            return true;
        }
        return false;
    }
}
