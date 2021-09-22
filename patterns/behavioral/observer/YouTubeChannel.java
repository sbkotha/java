package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements IObservable {
    String name;
    List<IObserver> channelSubscribers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.name = channelName;
    }

    @Override
    public void subscribe(IObserver observer) {
        this.channelSubscribers.add(observer);
    }

    @Override
    public void unSubscribe(IObserver observer) {
        this.channelSubscribers.remove(observer);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateAll() {
        for (IObserver each : channelSubscribers) {
            each.notifyChange();
        }
    }

    public void uploadSong() {
        this.updateAll();
    }
}
