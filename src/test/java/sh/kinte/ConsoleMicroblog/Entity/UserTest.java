package sh.kinte.ConsoleMicroblog.Entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kintesh on 16/05/15.
 */
public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("Alice");
        assertNotNull(user);
        assertEquals(user.getName(), "Alice");
    }

    @Test
    public void testUserEquals() {
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        assertNotNull(user1);
        assertNotNull(user2);

        assertFalse(user1.equals(user2));
        user2 = new User("Alice");
        assertTrue(user1.equals(user2));
    }

}
