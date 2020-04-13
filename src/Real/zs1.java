package Real;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-08
 */
public class zs1 {
    public static Map<Character, Character> alpha;

    public static void solve(String[] str) {
        for (int i = 0; i < str.length; i++) {
            char[] a = str[i].toCharArray();
            String tmp = new StringBuilder(str[i]).reverse().toString();
            char[] b = tmp.toCharArray();
            boolean f=true;
            for (int j = 0; j < b.length; j++) {
                char c=alpha.get(b[j]);
                if (a[j]!=c){
                    System.out.println("NO");
                    f=false;
                    break;
                }
            }
            if(f){
                System.out.println("YES");
            }
//            System.out.println(tmp);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        alpha = new HashMap<>();
        alpha.put('1', '1');
        alpha.put('2', '5');
        alpha.put('3', '8');
        alpha.put('4', '7');
        alpha.put('5', '2');
        alpha.put('6', '9');
        alpha.put('8', '3');
        alpha.put('7', '4');
        alpha.put('9', '6');

        String[] str = new String[t];
        for (int i = 0; i < t; i++) {
            str[i] = sc.next();
        }
        solve(str);
    }
}
