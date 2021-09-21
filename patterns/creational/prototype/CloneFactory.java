package patterns.creational.prototype;

public class CloneFactory {
    private static CloneFactory cf = new CloneFactory();
    private CloneFactory() {}
    public static CloneFactory getInstance() {
        return cf;
    }

    public IClonable makeCopy(IClonable clone) {
        try {
            return clone.getClone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
