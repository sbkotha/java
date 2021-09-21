package patterns.creational.abstractfactory;

public class AmericanCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new KiaCar();
    }

    @Override
    public Steering getSteering() {
        return new KiaSteering();
    }
}
