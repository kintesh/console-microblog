package sh.kinte.ConsoleMicroblog.Logic;

import sh.kinte.ConsoleMicroblog.Data.PostDO;
import sh.kinte.ConsoleMicroblog.Data.PostDOImpl;
import sh.kinte.ConsoleMicroblog.Data.UserDO;
import sh.kinte.ConsoleMicroblog.Data.UserDOImpl;
import sh.kinte.ConsoleMicroblog.Entity.Post;
import sh.kinte.ConsoleMicroblog.Entity.User;

import java.util.Set;

/**
 * Created by kintesh on 18/05/15.
 */
public class Service {

    private UserDO users;
    private PostDO posts;

    public Service() {
        users = new UserDOImpl();
        posts = new PostDOImpl();
    }

    protected User checkUser(String username) {
        User user = users.findByUsername(username);
        if (user == null) {
            return addUser(username);
        }
        return user;
    }

    protected User addUser(String username) {
        return users.create(username);
    }

    public void post(String username, String message) {
        checkUser(username);
        Post post = new Post(username, message);
        posts.create(post);
    }

    public String read(String username) {
        checkUser(username);
        StringBuilder sb = new StringBuilder();
        posts.findByUsername(username).stream()
                .forEach(p -> sb.append(p.getPost() + "\n"));
        return sb.toString();
    }

    public void follow(String username, String anotherUsername) {
        checkUser(username);
        users.addFollowing(username, anotherUsername);
    }

    protected Set<String> getFollowing(String username) {
        checkUser(username);
        return users.getFollowing(username);
    }

    public String wall(String username) {
        checkUser(username);
        StringBuilder sb = new StringBuilder();
        Set<String> following = getFollowing(username);
        posts.findAll().stream()
                .filter(p -> username.equals(p.getUsername()) || following.contains(p.getUsername()))
                .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                .forEach(p -> sb.append(p.getUsername() + " - " + p.getPost() + "\n"));
        return sb.toString();
    }


}
