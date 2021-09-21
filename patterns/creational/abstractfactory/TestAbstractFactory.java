package patterns.creational.abstractfactory;

import java.util.Scanner;

public class TestAbstractFactory {
    public static void main(String[] args) {
        CarFactory cf = AbstractFactory.getFactory("India");
        Car c = cf.getCar();
        Steering st = cf.getSteering();
        System.out.println(c.getCarSpec() + ":" + st.getSteeringSpec());

        cf = AbstractFactory.getFactory("USA");
        c = cf.getCar();
        st = cf.getSteering();
        System.out.println(c.getCarSpec() + ":" + st.getSteeringSpec());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter country (India/USA): ");
        cf = AbstractFactory.getFactory(sc.nextLine());
        c = cf.getCar();
        st = cf.getSteering();
        System.out.println("Your Car Spec");
        System.out.println(c.getCarSpec() + ":" + st.getSteeringSpec());
    }
}
