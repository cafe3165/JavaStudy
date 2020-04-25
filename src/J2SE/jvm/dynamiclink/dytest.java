package J2SE.jvm.dynamiclink;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class dytest {
    public static void main(String[] args) {
        Human father = new Father();
        Human mother = new Mother();
        father.call();
        mother.call();
    }

}
