package classic;

/**
 * Author:cafe3165
 * Date:2020-09-14
 */
public class ShellSort {
    public static void shell_sort(int array[], int lenth) {

        int temp = 0;
        int incre = lenth;

        while (true) {
            incre = incre / 2;

            for (int k = 0; k < incre; k++) {    //根据增量分为若干子序列

                for (int i = k + incre; i < lenth; i += incre) {

                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }

            if (incre == 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {50, 20, 17, 13, 28, 14, 23, 83};
        shell_sort(nums, nums.length);
    }
}
