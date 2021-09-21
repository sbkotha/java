package patterns.structural.bridge;

public abstract class AbstractView {
    protected IResource resource;
    public AbstractView(IResource newResource) {
        this.resource = newResource;
    }
    public abstract void renderResource();
}
