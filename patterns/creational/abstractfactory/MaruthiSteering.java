package patterns.creational.abstractfactory;

public class MaruthiSteering implements Steering {
    @Override
    public String getSteeringSpec() {
        return "I am on right side";
    }
}
