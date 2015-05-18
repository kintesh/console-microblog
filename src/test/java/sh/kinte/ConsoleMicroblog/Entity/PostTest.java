package sh.kinte.ConsoleMicroblog.Entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostTest {

    private Post post;

    @Before
    public void init() {
        post = new Post("Alice", "Test message.");
    }

    @Test
    public void testPostCreation() {
        assertNotNull(post);
        assertEquals(post.getUsername(), "Alice");
        assertEquals(post.getMessage(), "Test message.");
    }

    @Test
    public void testPostPrint() {
        assertNotNull(post.getPost());
    }
}
