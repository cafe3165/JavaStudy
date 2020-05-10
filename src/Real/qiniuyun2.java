package Real;
import java.util.Scanner;
/**
 * Author:cafe3165
 * Date:2020-05-07
 */
public class qiniuyun2 {
    public static int solve(int[] score,int b) {
        int res = 0;
        for (int i = 0; i < score.length; i++) {
            for (int j = i+1; j <score.length; j++) {
                if((score[j]-score[i])/(j-i)>=b){
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), b = sc.nextInt();
        int score[] = new int[n+1];
        score[0]=0;
        for (int i = 1; i <= n; i++) {
            score[i] = score[i-1] + sc.nextInt();
        }
        System.out.println(solve(score,b));
    }
}
