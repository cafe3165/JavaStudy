package J2SE.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class dynaTest {
    public static void main(String[] args) {
        MaoTai maoTai=new MaoTai();
        InvocationHandler dealer=new Counter(maoTai);
        SellWine dynamicProxy=(SellWine) Proxy.newProxyInstance(MaoTai.class.getClassLoader(),MaoTai.class.getInterfaces(),dealer);
        dynamicProxy.sell();
    }
}
