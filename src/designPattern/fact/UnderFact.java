package designPattern.fact;

public class UnderFact implements IFactory {
    @Override
    public Leifeng createLeifeng() {
        return new UnderGraduate();
    }
}
