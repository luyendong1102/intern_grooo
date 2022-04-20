import java.util.ArrayList;
import java.util.List;

public class Shell {
    private List<Command> commands;

    public Shell() {
        this.commands = new ArrayList<>();
    }

    public void addCommand (Command command) {
        this.commands.add(command);
    }

    public void excuteCommands() {
        for (Command command : commands) {
            command.excute();
        }
    }
}
