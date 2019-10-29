package javaGuide;
class RunnableDemo extends Thread {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    @Override
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
public class mutiThred extends Thread{
    private int number;
    public mutiThred(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int counter = 0;
        int guess = 0;

        do {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println(this.getName() + " guesses " + guess);
            counter++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while(guess != number);
        System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
    }


    public static void main(String[] args) {
//        RunnableDemo R1 = new RunnableDemo( "Thread-1");
//        R1.start();
//
//        RunnableDemo R2 = new RunnableDemo( "Thread-2");
//        R2.start();
        mutiThred m=new mutiThred(5);
        m.start();
    }
}

