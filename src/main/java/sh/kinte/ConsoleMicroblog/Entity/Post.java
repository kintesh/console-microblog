package sh.kinte.ConsoleMicroblog.Entity;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by kintesh on 17/05/15.
 */
public class Post {

    private User user;
    private String message;
    private LocalDateTime date;

    public Post(User user, String message) {
        this.user = user;
        this.message = message;
        this.date = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPost() {
        Long diff = Duration.between(getDate(), LocalDateTime.now()).getSeconds();
        String ds;
        if (diff < 60) {
            if (diff < 2) ds = diff + " second a go";
            else ds = diff + " seconds a go";
        } else if (diff < 3600) {
            if (diff / 60 < 2L) ds = diff / 60 + " minute a go";
            else ds = diff / 60 + " minutes a go";
        } else if (diff < 86400) {
            if (diff / 3600 < 2) ds = diff / 3600 + " hour a go";
            else ds = diff / 3600 + " hours a go";
        } else {
            if (diff / 86400 < 1) ds = diff / 86400 + " day a go";
            else ds = diff / 86400 + " days a go";
        }
        return getMessage() + " (" + ds + ")";
    }

    @Override
    public String toString() {
        return "P: " + getUser() + " " + getMessage() + " " + getDate();
    }

}
