package patterns.behavioral.command;

public class RemoteController {
    ICommand redCommand;
    ICommand whiteCommand;

    public void setRedButtonCommand(ICommand command) {
        this.redCommand = command;
    }

    public void setWhiteButtonCommand(ICommand command) {
        this.whiteCommand = command;
    }

    public void pressRedButton() {
        this.redCommand.execute();
    }

    public void pressWhiteButton() {
        this.whiteCommand.execute();
    }
}
