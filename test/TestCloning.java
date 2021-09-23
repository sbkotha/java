package test;

public class TestCloning {
    public static void main(String[] args) throws Exception {
        Parent t = new Parent();
        System.out.println(t);

        Parent t2 = t.clone();
        System.out.println(t2);

        System.out.println(System.identityHashCode(t.child));
        System.out.println(System.identityHashCode(t2.child));
    }
}

class Parent implements Cloneable {
    double value;
    Child child;
    Parent() {
        this.value = Math.random();
        this.child = new Child();
    }

    @Override
    public String toString() {
        return "Parent{" +
                "value=" + value +
                ", child=" + child +
                '}';
    }

    public Parent clone() throws CloneNotSupportedException {
        Parent p = (Parent) super.clone();
        p.child = child.clone();
        return p;
    }
}

class Child implements Cloneable {
    double value;
    Child() {
        this.value = Math.random();
    }

    @Override
    public String toString() {
        return "Child{" +
                "value=" + value +
                '}';
    }

    public Child clone() throws CloneNotSupportedException {
        return (Child) super.clone();
    }
}