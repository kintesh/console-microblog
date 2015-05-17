package sh.kinte.ConsoleMicroblog.Data;

import sh.kinte.ConsoleMicroblog.Entity.User;

import java.util.Set;

/**
 * Created by kintesh on 17/05/15.
 */
public interface UserDO {

    User findByUsername(String username);

    Set<User> findAll();

    User create(User user);
}
