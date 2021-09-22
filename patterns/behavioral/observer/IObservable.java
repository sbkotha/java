package patterns.behavioral.observer;

public interface IObservable {
    String getName();
    void subscribe(IObserver observer);
    void unSubscribe(IObserver observer);
    void updateAll();
}
