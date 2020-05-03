package designPattern.Observerpattern;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}