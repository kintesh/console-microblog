package sh.kinte.ConsoleMicroblog.Logic;

import sh.kinte.ConsoleMicroblog.Entity.Command;
import sh.kinte.ConsoleMicroblog.Entity.CommandType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kintesh on 17/05/15.
 */
public class Commander {

    private Pattern commandPattern;
    private Service service;

    public Commander() {
        commandPattern = Pattern.compile("([\\S]+)(?: *)([\\S]*)(?: *)([\\S ]*)");
        service = new Service();
    }

    public void runCommand(String input) {
        Command command = processInput(input);
        if (command != null) {
            switch (command.getCommandType()) {
                case POST:
                    service.post(command.getUsername(), command.getMessage());
                    System.out.println("");
                    break;
                case FOLLOW:
                    service.follow(command.getUsername(), command.getAnotherUser());
                    System.out.println("");
                    break;
                case WALL:
                    System.out.println(service.wall(command.getUsername()));
                    break;
                case READ:
                    System.out.println(service.read(command.getUsername()));
                    break;
                default:
                    break;
            }
        }
    }

    protected Command processInput(String input) {
        Matcher matcher = commandPattern.matcher(input);
        Command command = null;
        if (matcher.find()) {
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
