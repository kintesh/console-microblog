package sh.kinte.ConsoleMicroblog.Data;

import sh.kinte.ConsoleMicroblog.Entity.Post;

import java.util.Set;

/**
 * Created by kintesh on 17/05/15.
 */
public interface PostDO {

    Set<Post> findByUsername(String username);

    Set<Post> findAll();

    Post create(Post post);
}
