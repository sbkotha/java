package patterns.behavioral.command;

public class LightOnCommand implements ICommand {
    Light light = new Light();

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
