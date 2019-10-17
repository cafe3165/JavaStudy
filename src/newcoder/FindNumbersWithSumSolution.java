package newcoder;

import java.util.ArrayList;

public class FindNumbersWithSumSolution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> num = new ArrayList<>();
        int ph=0,pt=array.length-1;
        while(pt>ph){
            if(array[ph]+array[pt]==sum){
                num.add(array[ph]);
                num.add(array[pt]);
                break;
            }
            else if(array[ph]+array[pt]>sum)
                pt--;
            else
                ph++;
        }


        return num;

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = 6;
        FindNumbersWithSumSolution f = new FindNumbersWithSumSolution();
        f.FindNumbersWithSum(array, sum);

    }
}
