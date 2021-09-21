package patterns.behavioral.command;

public class LightOffCommand implements ICommand {
    Light light = new Light();

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }
}
