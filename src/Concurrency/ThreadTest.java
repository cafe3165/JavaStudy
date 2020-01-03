package Concurrency;

public class ThreadTest {
    public static class MyTread extends Thread{
        @Override
        public void run(){
            System.out.println("hello concurrency");
        }
    }

    public static void main(String[] args) {
        MyTread myTread=new MyTread();
        myTread.start();
    }

}
