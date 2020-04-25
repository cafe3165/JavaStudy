package J2SE.single;


/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class Singleton {
    private int num;

    private Singleton() {

    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private static class inner {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return inner.singleton;
    }

    public static void main(String[] args) {

        Thread thread1=new Thread(() -> {
            Singleton s1=new Singleton().getInstance();
            s1.setNum(s1.getNum()+1);
            System.out.println(s1.getNum());
        });

        Thread thread2=new Thread(()->{
            Singleton s2=new Singleton().getInstance();
            s2.setNum(s2.getNum()+10);
            System.out.println(s2.getNum());

        });
        thread1.start();
        thread2.start();


    }


}
