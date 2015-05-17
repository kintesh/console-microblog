package sh.kinte.ConsoleMicroblog.Entity;

/**
 * Created by kintesh on 17/05/15.
 */
public class Command {

    private CommandType commandType;
    private String username;
    private String message;
    private String anotherUser;

    public Command(String username) {
        this.username = username;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAnotherUser() {
        return anotherUser;
    }

    public void setAnotherUser(String anotherUser) {
        this.anotherUser = anotherUser;
    }

}
