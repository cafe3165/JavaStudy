package J2SE;

/**
 * Author:cafe3165
 * Date:2020-03-23
 */
public class IntegerTest {
    public static void main(String[] args) {
//        int i=128;
//        Integer I=128;
//        Integer J=new Integer(128);
//        System.out.println(i==I);
//        System.out.println(i==J);

//        Byte a=5;
//        int b=0;
//        int c=a>>2+b;
//        System.out.println(c);
//        short i=128;
//        System.out.println((byte)i);
//        int a=100;
//        Integer b=127;
//        Integer c=127;
//        System.out.println(a==b);
//        System.out.println(b==c);
        int i = 1;
        i=i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i + " " + j + " " + k);

    }
}
