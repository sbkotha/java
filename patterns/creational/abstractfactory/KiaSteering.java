package patterns.creational.abstractfactory;

public class KiaSteering implements Steering {
    @Override
    public String getSteeringSpec() {
        return "I am on the left";
    }
}
