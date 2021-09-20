package patterns.structural.composite;

public class TestComposite {
    public static void main(String[] args) {
        Directory root = new Directory("/");
        File file1 = new File("/my.text", 200);
        Directory child1 = new Directory("/scratch");
        Directory child2 = new Directory("/home");

        root.addComponent(file1);
        root.addComponent(child1);
        root.addComponent(child2);

        File child1file1 = new File("/scratch/file1", 3450);
        File child1file2 = new File("/scratch/file2", 450);
        child1.addComponent(child1file1);
        child1.addComponent(child1file2);

        File child2file1 = new File("/home/file1", 3450);
        File child2file2 = new File("/home/file2", 450);
        child2.addComponent(child2file1);
        child2.addComponent(child2file2);

        root.showDetails();
    }
}