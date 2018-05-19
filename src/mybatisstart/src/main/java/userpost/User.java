package userpost;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String username;
    private String mobile;
    private List<Post> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "User [id=" + id + " , name=" + username + " , mobile: " + mobile +"]";
    }
}
