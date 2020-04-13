package J2SE;

/**
 * Author:cafe3165
 * Date:2020-04-10
 */
@FunctionalInterface
public interface MyLamda {

    public void test1(String y);

//这里如果继续加一个抽象方法便会报错
//    public void test1();

    //default方法可以任意定义
    default String test2(){
        return "123";
    }

    default String test3(){
        return "123";
    }

    //static方法也可以定义
    static void test4(){
        System.out.println("234");
    }

}