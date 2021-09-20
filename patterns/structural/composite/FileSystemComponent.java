package patterns.structural.composite;

public interface FileSystemComponent {
    void showDetails();
    void addComponent(FileSystemComponent fsc);
}
