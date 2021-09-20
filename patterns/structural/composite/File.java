package patterns.structural.composite;

public class File implements FileSystemComponent {
    String name;
    int size;
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    @Override
    public void showDetails() {
        System.out.println("File: " + name + " - " + size + " bytes");
    }
}
