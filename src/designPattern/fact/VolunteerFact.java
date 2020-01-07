package designPattern.fact;

public class VolunteerFact implements IFactory {

    @Override
    public Leifeng createLeifeng() {
        return new Volunteer();
    }
}
