package J2SE;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class HelloTest {
    public static class hellpProxy implements InvocationHandler {
        public Hello hello=null;

        public hellpProxy(Hello hello) {
            this.hello=hello;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("hello proxy");
            return method.invoke(proxy,args);
        }
    }

    public static void main(String[] args) {
        Hello h=new HelloImpl();
        InvocationHandler helloP=new hellpProxy(h);
        Hello hp=(Hello) Proxy.newProxyInstance(helloP.getClass().getClassLoader(),h.getClass().getInterfaces(),helloP);
        hp.hi("world");

    }


}
