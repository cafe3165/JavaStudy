package designPattern.Order;

/**
 * Author:cafe3165
 * Date:2020-09-10
 */
public class Invoker {
    private ICommand concreteCommandA, concreteCommandB;

    public Invoker(ICommand concreteCommandA, ICommand concreteCommandB) {
        this.concreteCommandA = concreteCommandA;
        this.concreteCommandB = concreteCommandB;
    }

    public void orderA() {
        concreteCommandA.execute();
    }

    public void orderB() {
        concreteCommandB.execute();
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker(new ConcreteCommandA(receiver), new ConcreteCommandB(receiver));
        invoker.orderA();
        invoker.orderB();
    }
}
