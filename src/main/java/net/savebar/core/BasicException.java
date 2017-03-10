package net.savebar.core;


/**
 * Basic异常
 * key对应error.properties里的key.
 */
public class BasicException extends RuntimeException {
    public BasicException(String content) {
        super(content);
    }
}
