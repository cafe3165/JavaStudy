package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-28
 */
public class jbit1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next(),s2=sc.next();
        char[] chs1=s1.toCharArray();
        char[]chs2=s2.toCharArray();
        System.out.println(solve(chs1,chs2));

    }

    public static int solve(char[] chs1, char[] chs2) {
        int index2=chs2.length-1;
        for (int i = chs1.length-1; i>=0; i--) {
            if(chs2[index2]==chs1[i]&&index2==0){
                return i+1;
            }
            if(chs2[index2]==chs1[i]){
                index2--;
            }

        }


        return 0;
    }
}
