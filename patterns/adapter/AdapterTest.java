package patterns.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        Phone p = new Laptop2PhoneAdapter();
        SoftwareManager bm = new SoftwareManager(p);
        bm.patch();
    }
}
