package com.example.other;

/**
 * Author:cafe3165
 * Date:2023-03-06
 */
public class ClassB extends ClassA{

    private int a;

    private int b;

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.setB(1);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
