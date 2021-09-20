package patterns.creational.adapter;

public class Laptop2PhoneAdapter implements Phone {
    @Override
    public void upgradePhone() {
        Laptop lp = new Laptop();
        lp.updateOs();
    }
}
