package net.savebar.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by hxy on 2017/3/11.
 */
public class Bar implements Serializable{

    private static final long serialVersionUID = 7946447226987396985L;

    /**
     * 得到表名
     *
     * @return String
     */
    public static String tableName() {
        return "bar";
    }


    private long id;
    private long catalog;
    private String name;
    private String description;
    private Timestamp create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCatalog() {
        return catalog;
    }

    public void setCatalog(long catalog) {
        this.catalog = catalog;
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
}
