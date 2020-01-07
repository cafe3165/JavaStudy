package designPattern.fact;

public class Main {
    public static void main(String[] args) {
        IFactory fact = new UnderFact();
        Leifeng student = fact.createLeifeng();
        student.wash();
        student.sweep();
        student.buyRice();

    }
}
