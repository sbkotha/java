package patterns.creational.factory;

public class TestFactory {
    public static void main(String[] args) {
        CarFactory cf = CarFactory.getInstance();
        Car car1 = cf.getCar("low");
        car1.printSpec();
        Car car2 = cf.getCar("mid");
        car2.printSpec();
        Car car3 = cf.getCar("high");
        car3.printSpec();
    }
}
