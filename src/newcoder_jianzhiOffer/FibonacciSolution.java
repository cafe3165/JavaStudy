package newcoder_jianzhiOffer;

public class FibonacciSolution {
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }


    }

    public static int Fibonacci2(int n) {
        int f = 0;
        int g = 1;
        int res = f + g;

        for (int i = 2; i <= n; i++) {
            res = f + g;
            f=g;
            g=res;
        }
        if(n==0)
            return 0;
        else

            return res;

    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        int n =25;
        System.out.println(Fibonacci(n));
        System.out.println(Fibonacci2(n));
    }
}
