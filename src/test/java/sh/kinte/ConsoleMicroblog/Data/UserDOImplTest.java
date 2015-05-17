package sh.kinte.ConsoleMicroblog.Data;

import org.junit.Before;
import org.junit.Test;
import sh.kinte.ConsoleMicroblog.Entity.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kintesh on 17/05/15.
 */
public class UserDOImplTest {

    private UserDO users;

    @Before
    public void init() {
        users = new UserDOImpl();
        User user = new User("Alice");
        users.create(user);

        user = new User("Bob");
        users.create(user);

        user = new User("Charlie");
        users.create(user);

        user = new User("Bob");
        users.create(user);
    }

    @Test
    public void testCreate() {
        assertEquals(users.findAll().size(), 3);
    }

    @Test
    public void testFindByUsername() {
        assertNotNull(users.findByUsername("Bob"));
    }
}
