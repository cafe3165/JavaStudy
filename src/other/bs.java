package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */
public class bs {
    public static void main(String[] args) {
        bs su = new bs();
//        int[] arr = {1,3,6,9,12,23,33,44,45,67,78,98,100};
//        int res = su.binarySearch(arr, 44);
//        System.out.println("res=" + res);

        order o1=su.new order(10,17,1);
        order o2=su.new order(11,15,2);
        order o3=su.new order(19,18,3);
        order o4=su.new order(12,20,4);
        order o5=su.new order(13,17,5);
//        order[] ol=new order[5];
        List<order> ol=new ArrayList<>();
        ol.add(o1);
        ol.add(o2);
        ol.add(o3);
        ol.add(o4);
        ol.add(o5);

        Collections.sort(ol, new Comparator<order>() {
            @Override
            public int compare(order o1, order o2) {
                return o1.out-o2.out;
            }
        });

        for (order o :
                ol) {
            System.out.println(o.in+" "+o.out+" "+o.id);
        }

    }

    /**
     * 二分查找
     * @param arr 要进行查找的数组，要求数组必须是有序的
     * @param findElem 要查找的元素
     * @return 返回要查找的元素在数组的索引位置， 返回-1表示没找到
     */
    public int binarySearch(int[] arr, int findElem) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            //如果要查找的元素findElem小于中间位置的元素mid，指向数组的较大端的high索引重新指向中间索引mid的左边（mid-1）
            if (findElem < arr[mid]) {
                high = mid - 1;
            }
            //如果要查找的元素findElem大于中间位置的元素mid，指向数组的较小端的low索引重新指向中间索引mid的右边（mid+1）
            if (findElem > arr[mid]) {
                low = mid + 1;
            }
            if (arr[mid] == findElem) {
                return mid;
            }
        }
        return -1;
    }
    private static int recursiveFind(int[] arr,int start,int end,int searchKey){
        if (start <= end) {
            int middle =  (start+end)/2;
            if (searchKey == arr[middle]) {
                return middle;
            } else if (searchKey < arr[middle]) {
                return recursiveFind(arr, start, middle - 1, searchKey);
            } else {
                return recursiveFind(arr, middle + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }


    class order {
        int in;
        int out;
        int id;

        public order(int in, int out, int id) {
            this.in = in;
            this.out = out;
            this.id = id;
        }
    }

}
