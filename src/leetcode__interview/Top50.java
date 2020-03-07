package leetcode__interview;

/**
 * Author:cafe3165
 * Date:2020-03-05
 */
public class Top50 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }


//        System.out.println(fastPow(x,N));
        return fastPow(x,N);
    }

    public double fastPow(double x,long n){
        if(n==0){
            return 1.0;
        }
        double half=fastPow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }

    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        Top50 t = new Top50();
        t.myPow(x, n);

    }
}
