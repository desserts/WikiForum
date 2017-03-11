package net.savebar.bean;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * ResultModel
 * Created by hxy on 17/1/4.
 */
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = -6965042440878131675L;
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(ResultModel.class);

    public final static long EXCEPTION_CODE = -1;  //服务器内部错误
    public final static long FAIL_CODE = 0;   //失败
    public final static long SUCCESS_CODE = 200;  //成功


    private long code;
    private String message;
    private Date time;
    private T result;

    public ResultModel(long code, String message, T result) {
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
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return "";
        }
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
