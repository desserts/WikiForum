package net.savebar.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 访客
 * Created by hxy on 2015/8/29.
 */
public class Visitor implements Serializable {

    /**
     * 得到表名
     *
     * @return String
     */
    public static String TableName() {
        return "visitor";
    }


    private long id;
    private String ip;
    private Timestamp create_time;
    private String ua; //ua

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
