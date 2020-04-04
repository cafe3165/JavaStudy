package Real;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-01
 */
public class quna_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solve(a, b));

    }

    public static boolean solve(String a, String b) {

        HashMap<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            mapa.put(a.charAt(i), 1);
        }

        for (Character c:b.toCharArray()){
            if(mapa.get(c)!=null){
               mapa.put(c,mapa.get(c)+1);
            }else{
                return false;
            }
        }
        for(Character c:mapa.keySet()){
            if(mapa.get(c)==1){
                return false;
            }
        }


        return true;
    }
}
