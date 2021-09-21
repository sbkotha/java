package patterns.creational.prototype;

public interface IClonable extends Cloneable {
    IClonable getClone() throws CloneNotSupportedException;
}
