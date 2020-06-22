package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-21
 */
public class T88merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int[] num = new int[len];
        int i= 0, j = 0;
        int index=0;
        while(index<len){
            if(i<m&&j<n){
                if(nums1[i]<=nums2[j]){
                    num[index++]=nums1[i++];
                    continue;
                }else{
                    num[index++]=nums2[j++];
                    continue;
                }
            }
            if(i<m){
                num[index++]=nums1[i++];
            }
            if(j<n){
                num[index++]=nums2[j++];
            }
        }


        for (int k = 0; k < len; k++) {
            nums1[k] = num[k];
        }
    }

    public static void main(String[] args) {
        T88merge t = new T88merge();
        int[] nums1 = {4,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {1,2,3,4,5};
        int n = 5;
        t.merge(nums1, m, nums2, n);

    }
}
