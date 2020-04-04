package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class ProxySaler implements InvocationHandler {
    public Object person;

    public Object newInstall(Object person) {
        this.person = person;
//        System.out.println(person.getClass().getName());
        return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("执行方法前的操作");
        if (method.getName().equals("buy")) {
            ret = method.invoke(person, args);
//            person.buy();
        }
        if (method.getName().equals("buy1")) {
            ret = method.invoke(person, args);
//            person.buy1();
        }


        System.out.println("执行方法后的操作");
        return ret;
    }
}
