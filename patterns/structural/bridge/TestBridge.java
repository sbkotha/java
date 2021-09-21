package patterns.structural.bridge;

public class TestBridge {
    public static void main(String[] args) {
        AbstractView view = new LongView(new Book("DS", "This is a Data Structure Book", "www.amazon.com" ,"c:/test.jpg"));
        view.renderView();

        view = new ShortView(new Book("DS", "This is a Data Structure Book", "www.amazon.com" ,"c:/test.jpg"));
        view.renderView();
    }
}
