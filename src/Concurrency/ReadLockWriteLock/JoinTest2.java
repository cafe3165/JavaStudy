package Concurrency.ReadLockWriteLock;

import java.util.Random;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class JoinTest2 {
    public static void main(String[] args) {
        final TheData theData = new TheData();
        for(int i=0;i<4;i++){
            new Thread(() -> theData.get()).start();
        }
        for(int i=0;i<4;i++){
            new Thread(() -> theData.put(new Random().nextInt(1000))).start();
        }
    }
}
