package patterns.structural.composite;

import java.util.ArrayList;
import java.util.Collection;

public class Directory implements FileSystemComponent {
    String name;
    Collection<FileSystemComponent> dirContents = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(FileSystemComponent fsc) {
        this.dirContents.add(fsc);
    }

    @Override
    public void showDetails() {
        System.out.println("Contents of " + this.name + ":");
        if (dirContents.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (FileSystemComponent each : dirContents) {
                each.showDetails();
            }
        }
        System.out.println("");
    }
}