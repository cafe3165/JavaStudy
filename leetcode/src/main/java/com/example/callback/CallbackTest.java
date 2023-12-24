package com.example.callback;

/**
 * Author:cafe3165
 * Date:2023-07-23
 */
public class CallbackTest {

    public void printTest(String string, CallbackAI callbackAI) throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("printTest");
        callbackAI.printA(string);
    }

    public static void main(String[] args) throws InterruptedException {

        CallbackTest callbackTest = new CallbackTest();
        callbackTest.printTest("xiaoming", new CallbackAImpl());
    }
}
