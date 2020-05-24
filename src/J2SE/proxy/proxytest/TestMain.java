package J2SE.proxy.proxytest;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class TestMain {
    public static void main(String[] args) {
        ProxySaler proxySaler = new ProxySaler();
        Person object = (Person) proxySaler.newInstall(new xiaoQiang("黄豪强", "南山区"));
        object.buy1();
        object.buy();
    }

}
