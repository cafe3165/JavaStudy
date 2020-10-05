package designPattern.Order;

/**
 * Author:cafe3165
 * Date:2020-09-10
 */
public class ConcreteCommandB implements ICommand {
    private Receiver receiver;

    public ConcreteCommandB(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("ConcreteCommandB execute ...");
        receiver.execute();
    }

}
