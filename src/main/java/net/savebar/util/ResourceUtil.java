package net.savebar.util;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 国际化资源工具类
 */
public class ResourceUtil {

    private final static MyResourceBundleControl ctl = new MyResourceBundleControl();

    /**
     * 返回 {res}.properties 中 key 对应的值
     *
     * @param baseName baseName
     * @param key      key
     * @return String
     */
    public static String getString(String baseName, String key) {
        return _getStringForLocale(Locale.getDefault(), baseName, key);
    }


    /**
     * 返回 {res}.properties 中 key 对应的值
     *
     * @param locale   locale
     * @param baseName baseName
     * @param key      key
     * @return String
     */
    private static String _getStringForLocale(Locale locale, String baseName, String key) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle(baseName, locale, ResourceUtil.class.getClassLoader(), ctl);
            return (rb != null) ? rb.getString(key) : null;
        } catch (MissingResourceException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * 返回 {res}.properties 中 key 对应的值，并对值进行参数格式化
     *
     * @param baseName baseName
     * @param key      key
     * @param args     args
     * @return String
     */
    public static String getString(String baseName, String key, Object... args) {
        String text = getString(baseName, key);
        return (text != null) ? MessageFormat.format(text, args) : null;
    }

    /**
     * 返回 {res}.properties 中 key 对应的值，并对值进行参数格式化
     *
     * @param locale   locale
     * @param baseName baseName
     * @param key      key
     * @param args     args
     * @return String
     */
    public static String getStringForLocale(Locale locale, String baseName, String key, Object... args) {
        String text = _getStringForLocale(locale, baseName, key);
        return (text != null) ? MessageFormat.format(text, args) : null;
    }

    public static String loadFromResource(String resource) {
        InputStream in = null;
        BufferedReader reader = null;
        try {
            in = new FileInputStream(resource);
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            return IOUtils.toString(reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * 重载控制器，每1个小时重载一次
     */
    private static class MyResourceBundleControl extends ResourceBundle.Control {

        /**
         * 每1个小时重载一次
         */
        @Override
        public long getTimeToLive(String baseName, Locale locale) {
            return 3600000;
        }

        @Override
        public boolean needsReload(String baseName, Locale locale,
                                   String format, ClassLoader loader,
                                   ResourceBundle bundle, long loadTime) {
            return true;
        }
    }
}
