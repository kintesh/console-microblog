package sh.kinte.ConsoleMicroblog.Data;

import org.junit.Before;
import org.junit.Test;
import sh.kinte.ConsoleMicroblog.Entity.Post;

import static org.junit.Assert.assertEquals;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostDOImplTest {

    private PostDO posts;

    @Before
    public void init() {
        posts = new PostDOImpl();

        Post post = new Post("Alice", "I love the weather today");
        posts.create(post);

        post = new Post("Bob", "Damn! We lost!");
        posts.create(post);

        post = new Post("Bob", "Good game though.");
        posts.create(post);
    }

    @Test
    public void testCreate() {
        assertEquals(3, posts.findAll().size());
    }

    @Test
    public void testFindByUsername() {
        assertEquals(2, posts.findByUsername("Bob").size());
    }
}
