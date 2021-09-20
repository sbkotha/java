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

    @Override
    public void addComponent(FileSystemComponent fsc) {
        throw new UnsupportedOperationException("You can not add compoents to a File");
    }
}
