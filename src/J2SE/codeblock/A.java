package J2SE.codeblock;

/**
 * Author:cafe3165
 * Date:2020-04-28
 */
public class A {
    {
        System.out.println("代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public A() {
        System.out.println("构造方法");
    }

    public Number say(){
        return 2;

    }


}
