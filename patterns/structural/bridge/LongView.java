package patterns.structural.bridge;

public class LongView extends AbstractView {
    public LongView(IResource newResource) {
        super(newResource);
    }

    @Override
    public void renderView() {
        System.out.println(this.resource.getTitle());
        System.out.println(this.resource.getDescription());
        System.out.println(this.resource.getImageLocation());
        System.out.println(this.resource.getUrl());
    }
}
