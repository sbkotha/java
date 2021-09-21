package patterns.structural.bridge;

public class TestBridge {
    public static void main(String[] args) {
        AbstractView view = new LongView(new Book("DS", "This is a Data Structure Book", "www.amazon.com" ,"c:/test.jpg"));
        view.renderView();

        view = new ShortView(new Book("DS", "This is a Data Structure Book", "www.amazon.com" ,"c:/test.jpg"));
        view.renderView();

        view = new LongView(new ElectronicDevice("S7 Edge", "This is a smart phone by Samsung", "www.samsung.com" ,"c:/s7edge.jpg"));
        view.renderView();

        view = new ShortView(new ElectronicDevice("S7 Edge", "This is a smart phone by Samsung", "www.samsung.com" ,"c:/s7edge.jpg"));
        view.renderView();
    }
}
