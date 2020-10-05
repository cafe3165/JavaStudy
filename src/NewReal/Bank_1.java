package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-25
 */
public class Bank_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] infos = s.split(" ");
            int count = 0;
            for (int j = 0; j < infos.length; j++) {
                if (infos[j].equals("1")) {
                    count++;
                }
            }
            if (i < n - 1) {
                System.out.print((i + 1) + ":" + count + "/" + infos.length + ",");
            } else {
                System.out.print((i + 1) + ":" + count + "/" + infos.length);
            }

        }
    }
}
