package net.savebar.bean;

import java.io.Serializable;

/**
 * 用户
 * Created by hxy on 16/9/4.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -1426851343640326880L;


    public static final long ROOT_LEVEL = 0;


    /**
     * 得到表名
     *
     * @return String
     */
    public static String tableName() {
        return "user";
    }

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
