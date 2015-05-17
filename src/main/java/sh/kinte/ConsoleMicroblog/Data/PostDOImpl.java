package sh.kinte.ConsoleMicroblog.Data;

import sh.kinte.ConsoleMicroblog.Entity.Post;
import sh.kinte.ConsoleMicroblog.Entity.User;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostDOImpl implements PostDO {

    private Set<Post> posts;
    private UserDO users;

    public PostDOImpl(UserDO users) {
        posts = new HashSet<>();
        this.users = users;
    }

    @Override
    public Set<Post> findByUsername(String username) {
        User user = users.findByUsername(username);
        Set<Post> found = null;
        if (user != null) {
            found = posts.stream()
                    .filter(p -> p.getUser().equals(user))
                    .sorted((p1, p2) -> p1.getDate().compareTo(p2.getDate()))
                    .collect(toSet());
        }
        return found;
    }

    @Override
    public Set<Post> findAll() {
        return this.posts;
    }

    @Override
    public Post create(Post post) {
        posts.add(post);
        return post;
    }
}
