package net.savebar.core;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Writer;

/**
 * freemarker页面上的异常控制
 * 在freemarker.properties里面的配置
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(FreemarkerExceptionHandler.class);

    public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
        logger.error("[Freemarker Error: " + te.getMessage() + "]");
        throw new BasicException("freemarker error");
    }
}