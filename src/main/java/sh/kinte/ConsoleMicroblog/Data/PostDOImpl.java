package sh.kinte.ConsoleMicroblog.Data;

import sh.kinte.ConsoleMicroblog.Entity.Post;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by kintesh on 17/05/15.
 */
public class PostDOImpl implements PostDO {

    private Set<Post> posts;

    public PostDOImpl() {
        posts = new HashSet<>();
    }

    @Override
    public Set<Post> findByUsername(String username) {
        Set<Post> found = posts.stream()
                .filter(p -> p.getUsername().equals(username))
                .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                .collect(toSet());
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
