package sh.kinte.ConsoleMicroblog.Logic;

import sh.kinte.ConsoleMicroblog.Data.UserDO;
import sh.kinte.ConsoleMicroblog.Data.UserDOImpl;
import sh.kinte.ConsoleMicroblog.Entity.Command;
import sh.kinte.ConsoleMicroblog.Entity.CommandType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kintesh on 17/05/15.
 */
public class Commander {

    private Pattern commandPattern;
    private UserDO users;

    public Commander() {
        commandPattern = Pattern.compile("([\\S]+)(?: *)([\\S]*)(?: *)([\\S ]*)");
        users = new UserDOImpl();
    }

    public void runCommand(String input) {
        processInput(input);
    }

    protected Command processInput(String input) {
        Matcher matcher = commandPattern.matcher(input);
        Command command = null;
        if(matcher.find()) {
            command = new Command(matcher.group(1));
            if (CommandType.POST.getCommand().equals(matcher.group(2))) {
                command.setCommandType(CommandType.POST);
                command.setMessage(matcher.group(3));
            } else if (CommandType.FOLLOW.getCommand().equals(matcher.group(2))) {
                command.setCommandType(CommandType.FOLLOW);
                command.setAnotherUser(matcher.group(3));
            } else if (CommandType.WALL.getCommand().equals(matcher.group(2))) {
                command.setCommandType(CommandType.WALL);
            } else {
                command.setCommandType(CommandType.READ);
            }
        }
        return command;
    }
}
