package patterns.behavioral.observer;

public class YouTubeUser implements IObserver {
    YouTubeChannel channel;
    String name;
    public YouTubeUser(String newName) {
        this.name = newName;
    }

    public void setChannel(YouTubeChannel newChannel) {
        this.channel = newChannel;
    }

    @Override
    public void notifyChange() {
        System.out.println("Hey " + name + ", a new video has been uploaded by, " + this.channel.getName());
    }
}
