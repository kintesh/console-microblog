package sh.kinte.ConsoleMicroblog.Entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostTest {

    private User user;
    private Post post;

    @Before
    public void init() {
        user = new User("Alice");
        post = new Post(user, "Test message.");
    }

    @Test
    public void testPostCreation() {
        assertNotNull(user);
        assertNotNull(post);
        assertEquals(post.getUser().getName(), "Alice");
        assertEquals(post.getMessage(), "Test message.");
    }

    @Test
    public void testPostPrint() {
        assertNotNull(post.getPost());
    }
}
