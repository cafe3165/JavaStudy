package newcoder_jianzhiOffer;

public class FindNumsAppearOnceSolution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2)
            return;
        int temp = array[0];
        for (int i = 1; i < array.length; i++)
            temp = temp ^ array[i];
        if (temp == 0)
            return;
        int index = 0;
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            ++index;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if(((array[i]>>index)&1)==1)
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public static void main(String[] args) {
        FindNumsAppearOnceSolution f = new FindNumsAppearOnceSolution();
//        int[] array = {7, 4, 5, 4, 2, 5, 3, 6, 7, 2};
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = new int[1];
        int num2[] = new int[1];
        f.FindNumsAppearOnce(array, num1, num2);
    }
}
