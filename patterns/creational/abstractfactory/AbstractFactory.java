package patterns.creational.abstractfactory;

public class AbstractFactory {
    public static CarFactory getFactory(String country) {
        if ("India".equals(country)) {
            return new IndianCarFactory();
        } else if ("USA".equals(country)) {
            return new AmericanCarFactory();
        } else {
            throw new IllegalArgumentException(country + " is not a valid country");
        }
    }
}
