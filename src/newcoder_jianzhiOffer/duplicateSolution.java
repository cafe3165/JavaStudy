package newcoder_jianzhiOffer;

public class duplicateSolution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {


            int index = numbers[i];

            if (index >= length) {

                index -= length;

            }

            if (numbers[index] >= length) {
                duplication[0]=index;
                return true;

            }

            numbers[index] = numbers[index] + length;

        }
        return false;

    }

    public static void main(String[] args) {
        duplicateSolution d = new duplicateSolution();
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication =new int[1];
        d.duplicate(numbers, numbers.length, duplication);

    }
}
