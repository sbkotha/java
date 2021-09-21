package patterns.structural.bridge;

public class Book implements IResource {

    String title, desc, url, imageLoc;

    public Book(String title, String desc, String url, String imageLoc) {
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.imageLoc = imageLoc;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.desc;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getImageLocation() {
        return this.imageLoc;
    }
}
