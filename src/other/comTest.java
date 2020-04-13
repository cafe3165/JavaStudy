package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author:cafe3165
 * Date:2020-04-06
 */
public class comTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
// void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

// void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
// 定制排序的用法
        Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println("定制排序后：");
        System.out.println(arrayList);
    }
}
