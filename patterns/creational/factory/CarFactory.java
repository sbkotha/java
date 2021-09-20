package patterns.creational.factory;

public class CarFactory {
    private static CarFactory cf = null;
    
    public static CarFactory getInstance() {
        if (cf == null) {
            cf = new CarFactory();
        }
        return cf;
    }

    public Car getCar(String type) {
        if ("low".equals(type)) {
            return new IndicaCar();
        } else if ("mid".equals(type)) {
            return new SwiftDezireCar();
        } else if ("high".equals(type)) {
            return new HondaCityCar();
        }
        return null;
    }
}
