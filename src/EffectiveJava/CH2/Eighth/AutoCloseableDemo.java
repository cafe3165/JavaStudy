package EffectiveJava.CH2.Eighth;

/**
 * Author:cafe3165
 * Date:2020-06-12
 * 在finally中关闭资源存在以下问题：
 * 1、自己要手动写代码做关闭的逻辑；
 * 2、有时候还会忘记关闭一些资源；
 * 3、关闭代码的逻辑比较冗长，不应该是正常的业务逻辑需要关注的；
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (AutoCloseableObjecct app = new AutoCloseableObjecct()) {
            System.out.println("--执行main方法--");
        } catch (Exception e) {
            System.out.println("--exception--");
        } finally {
            System.out.println("--finally--");
        }
    }
    //自己定义类 并实现AutoCloseable
    public static class AutoCloseableObjecct implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("--close--");
            //在try-block执行完
        }

    }
}
