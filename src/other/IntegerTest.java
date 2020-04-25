package other;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class IntegerTest {
    public static void main(String[] args) {
//        Integer i1=128;
//        Integer i2=128;
//        System.out.println(i1==i2);
//        short s1=1;
//        s1= (short) (s1+1);

//        char a='a';
//        int aa=(int)a;
//        System.out.println(aa);
        int[] i = {1};
        int[] j = {1, 2};
        int[] k = {1, 2, 3};
        int[][] a = new int[3][3];
        a[0] = i;
        a[1] = j;
        a[2] = k;
        System.out.println(a);
        int[][] b= new int[][]{{1},{1,2},{1,2,3}};

        List<Integer> list=new ArrayList<>();

    }
}
