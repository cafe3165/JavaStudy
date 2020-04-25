package Concurrency.Interrupt;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class intertupeExce {

    class myThread extends  Thread{
        public void run(){
            try{
                for (int i = 0; i < 50000; i++) {
                    if(Thread.interrupted()){
                        System.out.println(this.getName()+"中断，退出");
                        throw new InterruptedException();
                    }
                }

                System.out.println("for后面的方法");
            }catch (InterruptedException e){
                System.out.println("run catch");
//                throw  new InterruptedException();
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        intertupeExce in=new intertupeExce();
        try{
            myThread th= in.new myThread();
            Thread.sleep(2000);
            th.start();
            th.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("main end");

    }
}
