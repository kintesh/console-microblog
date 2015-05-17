package sh.kinte.ConsoleMicroblog.Entity;

/**
 * Created by kintesh on 17/05/15.
 */
public enum CommandType {
    POST("->"), READ(""), FOLLOW("follows"), WALL("wall");

    private String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
