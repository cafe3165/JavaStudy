package J2SE.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class Counter implements InvocationHandler {
    private Object brand;

    public Counter(Object brand) {
        this.brand = brand;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始  柜台是： " + this.getClass().getSimpleName());
        method.invoke(brand, args);
        System.out.println("结束");
        return null;
    }
}
