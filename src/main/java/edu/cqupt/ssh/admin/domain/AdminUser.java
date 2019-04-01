package edu.cqupt.ssh.admin.domain;

/**
 * Created by aa on 2017/8/11.
 */
public class AdminUser {
    private Integer uid;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "AdminUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(Integer uid) {

        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
