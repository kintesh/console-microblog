package sh.kinte.ConsoleMicroblog.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kintesh on 16/05/15.
 */
public class User {

    private String name;
    private Set<String> following;

    public User(String name) {
        this.name = name;
        this.following = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getFollowing() {
        return following;
    }

    public void addFollowing(String anotherUser) {
        this.following.add(anotherUser);
    }

    @Override
    public String toString() {
        return "U: " + getName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final User other = (User) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        return true;
    }
}
