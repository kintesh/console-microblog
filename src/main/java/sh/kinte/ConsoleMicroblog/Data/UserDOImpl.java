package sh.kinte.ConsoleMicroblog.Data;

import sh.kinte.ConsoleMicroblog.Entity.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by kintesh on 17/05/15.
 */
public class UserDOImpl implements UserDO {

    private Set<User> users;
    private Set<String> following;

    public UserDOImpl() {
        users = new HashSet<>();
        following = new HashSet<>();
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> found = users.stream()
                .filter(u -> u.getName().equals(username))
                .findFirst();
        return found.isPresent() ? found.get() : null;
    }

    @Override
    public Set<User> findAll() {
        return this.users;
    }

    @Override
    public User create(String username) {
        User user = new User(username);
        users.add(user);
        return user;
    }

    @Override
    public void addFollowing(String username, String anotherUser) {
        findByUsername(username).addFollowing(anotherUser);
    }

    @Override
    public Set<String> getFollowing(String username) {
        return findByUsername(username).getFollowing();
    }
}
