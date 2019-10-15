import java.util.ArrayList;

public class GetUglyNumberSolution {
    public int GetUglyNumber_Solution(int index) {
        if(index<7)
            return index;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] U = new int[index];
        U[0]=1;
        for (int i = 1; i < index; i++) {
            U[i] = Math.min(Math.min(U[i2] * 2, U[i3] * 3), U[i5] * 5);
//            System.out.println(U[i]);
            if (U[i] == U[i2] * 2) i2++;
            if (U[i] == U[i3] * 3) i3++;
            if (U[i] == U[i5] * 5) i5++;
        }

        return U[index-1];
    }

    public static void main(String[] args) {
        int index = 7;
        GetUglyNumberSolution g = new GetUglyNumberSolution();
        g.GetUglyNumber_Solution(index);
    }
}
