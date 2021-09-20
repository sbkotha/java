package patterns.factory;

public class HondaCityCar implements Car {
    @Override
    public void printSpec() {
        System.out.println("I am Honda City car in High segment made by Honda");
    }
}
