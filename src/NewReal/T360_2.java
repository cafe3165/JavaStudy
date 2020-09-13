package NewReal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2020-09-11
 */
public class T360_2 {
    private static char[] special = {'~', '!', '@', '#', '$', '%',
            '^', '&', '*', '(', ')', '_', '+', '{', '}', '|', '<', '>', '?'};
    private static Set<Character> set;

    public static void judgePwd(String pwd) {
        set = new HashSet<>();
        for (Character c : special) {
            set.add(c);
        }
        if (pwd.length()>=8&&hasNum(pwd) && hasBig(pwd) && hasSmall(pwd) &&hashSp(pwd)){
            System.out.println("Ok");
        }else{
            System.out.println("Irregular password");
        }

    }

    private static boolean hashSp(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (set.contains(pwd.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasNum(String pwd) {
        int count = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            }
        }
        return count > 0;
    }

    private static boolean hasBig(String pwd) {
        int count = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        return count > 0;
    }

    private static boolean hasSmall(String pwd) {
        int count = 0;
        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c >= 'a' && c <= 'z') {
                count++;
            }
        }
        return count > 0;
    }


    public static void main(String[] args) {
//        String s1 = "12_Aaqq12";
//        String s2 = "Password123";
//        String s3 = "PASSWORD_123";
//        String s4 = "PaSS^word";
//        String s5 = "12_Aaqq";
//        judgePwd(s1);
//        judgePwd(s2);
//        judgePwd(s3);
//        judgePwd(s4);
//        judgePwd(s5);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.next();
            judgePwd(s);
        }



    }
}
