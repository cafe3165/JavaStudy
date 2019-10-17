package newcoder;

public class PowerSolution {
    public static double Power(double base, int exponent) {
//        double res = 0.0;


            if (exponent > 0)
                return Math.pow(base, exponent);
            else
                return Math.pow(1 / base, Math.abs(exponent));





//        return res;
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = -3;
        System.out.println(Power(base, exponent));
    }
}
