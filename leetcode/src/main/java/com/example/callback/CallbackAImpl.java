package com.example.callback;

/**
 * Author:cafe3165
 * Date:2023-07-23
 */
public class CallbackAImpl implements CallbackAI{
    @Override
    public void printA(String name) throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println(name + "callbackA");
    }
}
