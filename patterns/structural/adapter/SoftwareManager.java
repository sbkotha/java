package patterns.structural.adapter;

public class SoftwareManager {
    Phone p;

    public SoftwareManager(Phone p) {
        this.p = p;
    }

    public void patch() {
        System.out.println("Attempting the patch");
        p.upgradePhone();
    }
}
