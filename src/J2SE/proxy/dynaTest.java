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
        Counter dealer=new Counter(maoTai);
        SellWine seller=dealer.bind(maoTai) ;
        seller.sell();
//        Proxy.newProxyInstance(MaoTai.class.getClassLoader(),MaoTai.class.getInterfaces(),dealer);

    }
}
