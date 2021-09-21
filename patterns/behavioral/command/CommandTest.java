package patterns.behavioral.command;

public class CommandTest {
    public static void main(String[] args) {
        Light light = new Light();

        RemoteController rc = new RemoteController();
        rc.setRedButtonCommand(new LightOnCommand(light));
        rc.setWhiteButtonCommand(new LightOffCommand(light));
        System.out.print("Pressing Red: ");
        rc.pressRedButton();
        System.out.print("Pressing White: ");
        rc.pressWhiteButton();

        // Swap the buttons now
        rc.setWhiteButtonCommand(new LightOnCommand(light));
        rc.setRedButtonCommand(new LightOffCommand(light));

        System.out.print("Pressing Red: ");
        rc.pressRedButton();
        System.out.print("Pressing White: ");
        rc.pressWhiteButton();
    }
}
