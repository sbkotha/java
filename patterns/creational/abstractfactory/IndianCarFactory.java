package patterns.creational.abstractfactory;

public class IndianCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new MaruthiCar();
    }

    @Override
    public Steering getSteering() {
        return new MaruthiSteering();
    }
}
