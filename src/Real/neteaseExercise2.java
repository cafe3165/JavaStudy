package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-04
 */
public class neteaseExercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n+=Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
        System.out.println(n);


    }
}
