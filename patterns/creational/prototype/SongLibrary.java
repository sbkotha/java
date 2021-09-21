package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class SongLibrary implements IClonable {

    String name;
    List<String> songs;

    public SongLibrary(String newName) {
        this.name = newName;
        this.songs = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            this.songs.add("Song " + i);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SongLibrary{" +
                "name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }

    @Override
    public IClonable getClone() throws CloneNotSupportedException {
        return (IClonable) this.clone();
    }

}