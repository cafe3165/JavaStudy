package com.example.alicode;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Author:cafe3165
 * Date:2023-07-23
 */
public class RandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println("random: " + random.nextInt());
            System.out.println("random: " + random.nextInt());
            System.out.println("random: " + random.nextInt());
            // fixme:
            /// 后续使用
//            System.out.println(threadLocalRandom.nextInt());
        }

    }
}
