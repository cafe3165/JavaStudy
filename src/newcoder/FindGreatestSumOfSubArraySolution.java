package newcoder;

public class FindGreatestSumOfSubArraySolution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = Integer.MIN_VALUE;
        int[] f = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || f[i - 1] < 0)
                f[i] = (array[i]);
             else
                f[i] = f[i - 1] + array[i];
            if(f[i]>sum)
                sum=f[i];

        }
        for (int ff :
                f) {
            System.out.println(ff);
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        FindGreatestSumOfSubArraySolution f = new FindGreatestSumOfSubArraySolution();
        f.FindGreatestSumOfSubArray(array);
    }
}

