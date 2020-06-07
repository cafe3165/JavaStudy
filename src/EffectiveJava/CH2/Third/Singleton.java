package EffectiveJava.CH2.Third;

/**
 * Author:cafe3165
 * Date:2020-06-06
 */
public class Singleton {
    public static void main(String[] args) {
        Elvis e1=Elvis.INSTANCE;
        Elvis e2=Elvis.INSTANCE;
        System.out.println(e1==e2);
    }

}
