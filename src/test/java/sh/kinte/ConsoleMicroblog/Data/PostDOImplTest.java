package sh.kinte.ConsoleMicroblog.Data;

import org.junit.Before;
import org.junit.Test;
import sh.kinte.ConsoleMicroblog.Entity.Post;
import sh.kinte.ConsoleMicroblog.Entity.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostDOImplTest {

    private PostDO posts;

    @Before
    public void init() {
        UserDO users = new UserDOImpl();
        User user = new User("Alice");
        users.create(user);

        user = new User("Bob");
        users.create(user);

        user = new User("Charlie");
        users.create(user);

        posts = new PostDOImpl(users);

        user = new User("Alice");
        Post post = new Post(user, "I love the weather today");
        posts.create(post);

        user = new User("Bob");
        post = new Post(user, "Damn! We lost!");
        posts.create(post);

        post = new Post(user, "Good game though.");
        posts.create(post);
    }

    @Test
    public void testCreate() {
        assertEquals(posts.findAll().size(), 3);
    }

    @Test
    public void testFindByUsername() {
        assertEquals(posts.findByUsername("Bob").size(), 2);
    }
}
