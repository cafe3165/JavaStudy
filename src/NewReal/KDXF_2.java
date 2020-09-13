package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class KDXF_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        mergeSort(nums,0,nums.length-1,tmp);
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1){
                System.out.print(nums[i]+" ");
            }else{
                System.out.print(nums[i]);
            }
        }
    }

    private static void mergeSort(int[] nums, int l, int h, int[] tmp) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            mergeSort(nums, l, mid, tmp);
            mergeSort(nums, mid + 1, h, tmp);
            merge(nums, l, mid, h, tmp);
        }
    }

    private static void merge(int[] nums, int l, int m, int h, int[] tmp) {
        int i = 0, j = l, k = m + 1;
        while (j <= m && k <= h) {
            if (nums[j] < nums[k]) {
                tmp[i++] = nums[j++];
            } else {
                tmp[i++] = nums[k++];
            }
        }
        while (j <= m) {
            tmp[i++] = nums[j++];
        }
        while (k <= h) {
            tmp[i++] = nums[k++];
        }
        for (int n = 0; n < i; n++) {
            nums[n + l] = tmp[n];
        }
    }
}
