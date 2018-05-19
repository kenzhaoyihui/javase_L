package springmybatis.order.pojo;

/**
 * @author yzhao_sherry
 * @version v1.0
 * @copyright redhat
 */

public class User {
    private int id;
    private String username;
    private String mobile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
