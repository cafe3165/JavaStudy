package com.example.leetcode.leetcode_daily.June;

public class T215findKthLargest {
    public int findKthLargest(int[] nums, int k) {

         findkth(nums,0,nums.length-1,nums.length-k);
         return nums[nums.length-k];

    }
    private static void findkth(int[] a, int l, int r, int n) {
        if (l == r) {
            return;
        }
        int p = part(a, l, r);
        int m = p - l + 1;
        if (n == m) {
            return;
        } else if (n < m) {
            findkth(a, l, p - 1, n);
        } else {
            findkth(a, p + 1, r, n);
        }
    }

    private static int part(int[] a, int l, int r) {
        int tmp = a[l];
        while (l < r) {
            while (l < r && a[r] > tmp) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] <= tmp) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = tmp;
        return l;
    }

    public static void main(String[] args) {
        T215findKthLargest t = new T215findKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        System.out.println( t.findKthLargest(nums,k));

    }
}
