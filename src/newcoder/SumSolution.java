package newcoder;

public class SumSolution {
    public int Sum_Solution(int n) {
        int ans=n;
        boolean f=(ans>0)&&((ans+=Sum_Solution(n-1))>0);

        return ans;


    }

    public static void main(String[] args) {
        int n = 10;
        SumSolution s = new SumSolution();
        System.out.println(s.Sum_Solution(n));;
    }
}
