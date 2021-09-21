package patterns.structural.bridge;

public class ElectronicDevice implements IResource {

    String title, desc, url, imageLoc;

    public ElectronicDevice(String title, String desc, String url, String imageLoc) {
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.imageLoc = imageLoc;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getImageLocation() {
        return imageLoc;
    }
}
