package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class WY_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub=s.substring(i,j);
                if(sub.length()>=res){
                    if(judge(sub)){
                        res=Math.max(res,sub.length());
                    }
                }

            }
        }
        System.out.println(res);

    }

    private static boolean judge(String s) {
        int[] count = new int[6];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                count[0]++;
            } else if (c == 'b') {
                count[1]++;
            } else if (c == 'c') {
                count[2]++;
            } else if (c == 'x') {
                count[3]++;
            } else if (c == 'y') {
                count[4]++;
            } else if(c=='z'){
                count[5]++;
            }
        }
        for (int j = 0; j < 6; j++) {
            if (count[j] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
