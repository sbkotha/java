package test;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) throws Exception {
        ParentClass t = new ParentClass();
        t.print();
        t.child.print();

        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ParentClass t2 = (ParentClass) ois.readObject();
        t2.print();
        if (t2.child != null) t2.child.print();
    }
}

class ParentClass implements Serializable {
    transient double value;
    ChildClass child;
    ParentClass() {
        this.value = Math.random();
        this.child = new ChildClass();
    }
    void print() {
        System.out.println(this.value);
    }
}

class ChildClass implements Serializable {
    double value;
    ChildClass() {
        this.value = Math.random();
    }
    void print() {
        System.out.println(this.value);
    }
}
