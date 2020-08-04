package Real;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-01F
 */
public class yuanfudao_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] begin = new int[N];
        int[] end = new int[N];
        int heart=0;
        for (int i = 0; i < N; i++) {
            begin[i]=sc.nextInt();
            end[i]=sc.nextInt();
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        for (int i = 0,j=0; i < N; i++) {
            if(begin[i]<end[j]){
                heart++;
            }else{
                j++;
            }
        }
        System.out.println(heart);
    }
}
