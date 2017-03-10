package net.savebar.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求工具类
 * 封装了一下request和response
 * Created by hxy on 2015/9/26.
 */

@WebAppConfiguration
@Component
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    public final static String VISITOR_SESSION_KEY = "VISITOR";
    public final static String ADMIN_SESSION_KEY = "USER";
    public final static String ADMIN_SESSION_VALUE = "ADMIN";

    @Autowired(required = false)
    private HttpServletRequest request;


    /**
     * 获取请求中的参数
     *
     * @param name         key名称
     * @param defaultValue 默认值
     * @return object
     */
    public String param(String name, String defaultValue) {
        try {
            String value = request.getParameter(name);
            if (value != null) {
                return value;
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public long param(String name, long defaultValue) {
        try {
            String value = request.getParameter(name);
            if (value != null) {
                return Long.parseLong(value);
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            return defaultValue;
        }
    }



    /**
     * 判断当前访问者是否是管理员
     *
     * @return boolean
     */
    public boolean isAdmin() {
        String user = (String) request.getSession().getAttribute(ADMIN_SESSION_KEY);
        return user != null && user.equals(ADMIN_SESSION_VALUE);
    }

    /**
     * 拿到用户的真实ip地址
     *
     * @return ip地址
     */
    public String ip() {
        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 拿到ua
     *
     * @return string
     */
    public String userAgent() {
        return request.getHeader("user-agent");
    }

    public void buildAdminKeyIntoSession() {
        logger.info("buildAdminKeyIntoSession");
        request.getSession().setAttribute(RequestUtil.ADMIN_SESSION_KEY, RequestUtil.ADMIN_SESSION_VALUE);
    }


    /**
     * 检查是否手机
     * @return true是  false不是
     */
    public boolean checkIsMobile() {
        String userAgent = userAgent();
        if (StringUtils.isBlank(userAgent)) {
            return false;
        }
        userAgent = userAgent.toLowerCase();
        for (String mobile : MOBILE_AGENTS) {
            if (userAgent.contains(mobile)) {
                return true;
            }
        }
        return false;
    }

    // 微软触摸式平板电脑（去掉 surface笔记本电脑 Tablet关键字 ）
    static final String[] MOBILE_AGENTS = {"android", "iphone", "ipad", "ipaq", "240x320", "acer", "acoon",
            "acs-", "abacho", "ahong", "airness", "alcatel", "amoi", "anywhereyougo.com", "applewebkit/525",
            "applewebkit/532", "asus", "audio", "au-mic", "avantogo", "becker", "benq", "bilbo", "bird", "blackberry",
            "blazer", "bleu", "cdm-", "compal", "coolpad", "danger", "dbtel", "dopod", "elaine", "eric", "etouch",
            "fly ", "fly_", "fly-", "go.web", "goodaccess", "gradiente", "grundig", "haier", "hedy", "hitachi", "htc",
            "huawei", "hutchison", "inno", "jbrowser", "kddi", "kgt", "kwc", "lenovo", "lg ", "lg2", "lg3", "lg4",
            "lg5", "lg7", "lg8", "lg9", "lg-", "lge-", "lge9", "longcos", "maemo", "mercator", "meridian", "micromax",
            "midp", "mini", "mitsu", "mmm", "mmp", "mobi", "mot-", "moto", "nec-", "netfront", "newgen", "nexian",
            "nf-browser", "nintendo", "nitro", "nokia", "nook", "novarra", "obigo", "palm", "panasonic", "pantech",
            "philips", "phone", "pg-", "playstation", "pocket", "pt-", "qc-", "qtek", "rover", "sagem", "sama", "samu",
            "sanyo", "samsung", "sch-", "scooter", "sec-", "sendo", "sgh-", "sharp", "siemens", "sie-", "softbank",
            "sony", "spice", "sprint", "spv", "symbian", "talkabout", "tcl-", "teleca", "telit", "tianyu",
            "tim-", "toshiba", "tsm", "up.browser", "utec", "utstar", "verykool", "virgin", "vk-", "voda", "voxtel",
            "vx", "wap", "wellco", "wig browser", "wii", "windows ce", "wireless", "xda", "xde", "zte", "iemobile",
            "windows phone", "windowsce", "ucweb"};



    public HttpServletRequest getRequest() {
        return request;
    }
}
