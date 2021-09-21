package patterns.structural.bridge;

public class ShortView extends AbstractView {
    public ShortView(IResource newResource) {
        super(newResource);
    }

    @Override
    public void renderView() {
        System.out.println(this.resource.getTitle());
        System.out.println(this.resource.getDescription());
    }
}
