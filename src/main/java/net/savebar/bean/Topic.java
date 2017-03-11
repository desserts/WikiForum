package net.savebar.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Topic
 * Created by hxy on 2017/3/11.
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = -4691560265074410262L;


    private long id;
    private long user_id;
    private long bar_id;
    private String name;
    private String description;
    private Timestamp create_time;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public long getBar_id() {
        return bar_id;
    }

    public void setBar_id(long bar_id) {
        this.bar_id = bar_id;
    }
}
