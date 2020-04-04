package other;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class qsort {
    public static void mysort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = PartSort(array, left, right);
        mysort(array, left, index - 1);
        mysort(array, index + 1, right);

//        System.out.println(array);
    }

    private static int PartSort(int[] array, int left, int right) {
        int key = array[right];
        while (left < right) {
            while (left < right && array[left] <= key) {
                left++;
            }
            while (left < right && array[right] >= key) {
                right--;
            }
            swap(array,left,right);
        }
        swap(array,left,right);
        return left;


    }

    public static void swap(int[] array,int a, int b) {
        int tmp = array[a];
        array[a]= array[b];
        array[b] = tmp;
    }


    public static void main(String[] args) {
        int[] array = {4, 1, 7, 6, 9, 2, 8, 0, 3, 5};
        mysort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
