package other;

/**
 * Author:cafe3165
 * Date:2020-03-30
 */

//    代码块->构造方法->静态代码块，其中静态代码块只会执行一次

public class Main {

    public static Main t1=new Main();

    Main(){
        System.out.println("BlockC");
    }
    {
        System.out.println("blockA");
    }
    static {
        System.out.println("blockB");
    }




    public static void main(String[] args){
        Main t2=new Main();
        System.out.println();
        Main t3=new Main();
    }
}