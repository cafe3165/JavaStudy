package newcoder_jianzhiOffer;

public class multiplySolution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                B[i] *= A[j];
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A.length - 1; j > i; j--) {
                B[i] *= A[j];
            }

        }

        for (int n :
                B) {
            System.out.println(n);
        }
        return B;

    }
//第二种方法
    public int[] multiply2(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }
        for (int i = 0; i < B.length; i++) {
            int tmp=A[i];
            A[i]=1;
            for (int j = 0; j < A.length; j++) {
                B[i]*=A[j];
            }
            A[i]=tmp;
        }
        return B;
    }


    public static void main(String[] args) {
        multiplySolution m = new multiplySolution();
        int[] A = {1, 2, 3, 4, 5};
        m.multiply2(A);
    }
}
