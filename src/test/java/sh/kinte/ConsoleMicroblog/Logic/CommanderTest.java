package sh.kinte.ConsoleMicroblog.Logic;

import org.junit.Before;
import org.junit.Test;
import sh.kinte.ConsoleMicroblog.Entity.Command;
import sh.kinte.ConsoleMicroblog.Entity.CommandType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kintesh on 17/05/15.
 */
public class CommanderTest {

    private Commander commander;

    @Before
    public void init() {
        commander = new Commander();
    }

    @Test
    public void testProcessInput() {
        Command post = commander.processInput("Alice -> I love the weather today");
        assertNotNull(post);
        assertEquals(post.getCommandType(), CommandType.POST);
        assertEquals(post.getUsername(), "Alice");
        assertEquals(post.getMessage(), "I love the weather today");

        Command read = commander.processInput("Bob");
        assertNotNull(read);
        assertEquals(read.getCommandType(), CommandType.READ);
        assertEquals(read.getUsername(), "Bob");

        Command follow = commander.processInput("Charlie follows Alice");
        assertNotNull(follow);
        assertEquals(follow.getCommandType(), CommandType.FOLLOW);
        assertEquals(follow.getUsername(), "Charlie");
        assertEquals(follow.getAnotherUser(), "Alice");

        Command wall = commander.processInput("Charlie wall");
        assertNotNull(wall);
        assertEquals(wall.getCommandType(), CommandType.WALL);
        assertEquals(wall.getUsername(), "Charlie");
    }
}
