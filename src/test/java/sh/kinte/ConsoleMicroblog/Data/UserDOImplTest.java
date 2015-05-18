package sh.kinte.ConsoleMicroblog.Data;

import org.junit.Before;
import org.junit.Test;

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

        users.create("Alice");
        users.create("Bob");
        users.create("Charlie");
        users.create("Bob");
    }

    @Test
    public void testCreate() {
        assertEquals(3, users.findAll().size());
    }

    @Test
    public void testFindByUsername() {
        assertNotNull(users.findByUsername("Bob"));
    }
}
