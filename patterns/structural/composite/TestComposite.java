package patterns.structural.composite;

public class TestComposite {
    public static void main(String[] args) {
        FileSystemComponent root = new Directory("/");
        FileSystemComponent file1 = new File("/my.text", 200);
        FileSystemComponent child1 = new Directory("/scratch");
        FileSystemComponent child2 = new Directory("/home");

        root.addComponent(file1);
        root.addComponent(child1);
        root.addComponent(child2);

        FileSystemComponent child1file1 = new File("/scratch/file1", 3450);
        FileSystemComponent child1file2 = new File("/scratch/file2", 450);
        child1.addComponent(child1file1);
        child1.addComponent(child1file2);

        FileSystemComponent child2file1 = new File("/home/file1", 3450);
        FileSystemComponent child2file2 = new File("/home/file2", 450);
        child2.addComponent(child2file1);
        child2.addComponent(child2file2);

        root.showDetails();
    }
}