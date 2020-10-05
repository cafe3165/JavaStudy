package designPattern.Order;

/**
 * Author:cafe3165
 * Date:2020-09-10
 */
public class ConcreteCommandA implements ICommand {
    private Receiver receiver;

    public ConcreteCommandA(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("ConcreteCommandA execute ...");
        receiver.execute();
    }
}
