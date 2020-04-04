package proxytest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class CglibProxy implements MethodInterceptor {

    public Object newInstall(Object object) {

        return Enhancer.create(object.getClass(), this);
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("先热身一会");
        methodProxy.invokeSuper(o,objects);
        System.out.println("打完了");
        return null;
    }
}
