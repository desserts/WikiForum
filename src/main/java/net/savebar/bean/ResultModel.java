package net.savebar.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * ResultModel
 * Created by hxy on 17/1/4.
 */
public class ResultModel<T> {
    public final static int EXCEPTION_CODE = -1;  //服务器内部错误
    public final static int FAIL_CODE = 0;   //失败
    public final static int SUCCESS_CODE = 1;  //成功


    private int code;
    private String message;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private T result;

    public ResultModel(int code, String message, T result) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.time = new Date();
    }

    /**
     * 对ApiResultModel的实例化进行阉割
     */
    private ResultModel() {
    }


    public String json() {
        return JSON.toJSONString(this);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
