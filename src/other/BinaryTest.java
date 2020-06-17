package other;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-06-15
 */
public class BinaryTest {
    public static void main(String[] args) {
        int[] a = {3, 5, 6, 7, 8, 9};
        System.out.println(Arrays.binarySearch(a, 4));
        System.out.println(Arrays.binarySearch(a, 0));
        System.out.println(Arrays.binarySearch(a, 10));
        System.out.println(Arrays.binarySearch(a, 6));
    }
}
