package sh.kinte.ConsoleMicroblog.Logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kintesh on 18/05/15.
 */
public class ServiceTest {

    private Service service;

    @Before
    public void init() {
        service = new Service();
    }

    @Test
    public void testPost() {
        assertNotNull(service);
        service.post("Alice", "I love the weather today");
        assertNotEquals("", service.read("Alice"));
        assertEquals("", service.read("Bob"));
    }

    @Test
    public void testFollow() {
        assertNotNull(service);
        service.follow("Alice", "Bob");
        assertEquals(1, service.getFollowing("Alice").size());
        assertEquals(0, service.getFollowing("Bob").size());
    }

    @Test
    public void testWall() {
        assertNotNull(service);
        service.post("Alice", "I love the weather today");
        service.post("Bob", "Damn! We lost!");
        service.post("Bob", "Good game though.");
        service.follow("Alice", "Bob");
        service.wall("Alice");
        assertNotEquals("", service.wall("Alice"));
        assertNotEquals("", service.wall("Bob"));
        assertEquals("", service.wall("Charlie"));
    }
}
