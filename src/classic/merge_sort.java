package classic;

/**
 * Author:cafe3165
 * Date:2020-05-10
 */
public class merge_sort {
    //排序函数
    public static void merge(int[] a, int low, int high, int[] copy) {
        int i = low;
        int m = (low+high)/2;
        int j = m + 1;
        int n = high;
        int xi = 0;//暂时存放数组

        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                copy[xi++] = a[i++];
            } else {
                copy[xi++] = a[j++];
            }
        }
        while (i <= m) {
            copy[xi++] = a[i++];
        }
        while (j <= n) {
            copy[xi++] = a[j++];
        }

        for (i = 0; i < xi; i++) {
            a[low + i] = copy[i];
        }
    }
    //递归的把数组划分为两个子数组，一直递归到数组中只有一个元素
    static void partition(int a[],int low,int high,int copy[])
    {
        if(low<high)//设置递归出口
        {
            int mid=(low+high)/2;
            partition(a,low,mid,copy);//左边
            partition(a,mid+1,high,copy);//右边
            merge(a,low,high,copy);//调用归并排序函数，两个有序数组排序import java.util.Scanner;
        }
    }
    public void sort(int[] a) {
        int n=a.length;
        int[] b=new int[n];
        partition(a, 0, n-1, b);
    }
    public static void main(String[] args) {
        int[] b= {12,39,83,325,62,392,417,23};
        merge_sort p1=new merge_sort();
        p1.sort(b);
        for (int i : b)
        {
            System.out.print(i+" ");
        }

    }
}
