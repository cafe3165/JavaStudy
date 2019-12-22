package newcoder;

public class cutRopeSolution {
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        } else if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }

        int[] products = new int[target + 1];

        for (int i = 0; i < 4; i++)
            products[i] = i;

        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                if(max<products[j]*products[i-j]){
                    max=products[j]*products[i-j];
                }
            }
            products[i]=max;

        }

        return products[target];

    }

    public static void main(String[] args) {
        cutRopeSolution c = new cutRopeSolution();
        System.out.println(c.cutRope(8));
    }
}
