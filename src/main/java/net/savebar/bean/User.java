package net.savebar.bean;

/**
 * 用户
 * Created by hxy on 16/9/4.
 */
public class User {

    public static final long ROOT_LEVEL = 0;

    private long id;
    private String name;
    private String password;
    private long level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }
}
