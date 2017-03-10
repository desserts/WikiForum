package net.savebar.util;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 缓存工具类
 * Created by hxy on 2015/10/17.
 */

public class CacheUtil {

    private static final Logger logger = LoggerFactory.getLogger(CacheUtil.class);

    /**
     * 拿到缓存
     *
     * @param name 缓存名
     * @param key  缓存key
     * @return object
     */
    public static Object get(String name, String key) {
        Cache cache = CacheManager.getInstance().getCache(name);
        if (cache == null) {
            logger.info("cache is null , name:" + name);
            return null;
        }
        Element element = cache.get(key);
        if (element == null) {
            logger.info("cache element is null , name:" + name + " key:" + key);
            return null;
        }
        return element.getObjectValue();
    }

    /**
     * 设置缓存
     *
     * @param name   缓存名字
     * @param key    缓存key
     * @param object 要缓存的对象
     */
    public static void set(String name, String key, Object object) {
        Cache cache = CacheManager.getInstance().getCache(name);
        if (cache == null) {
            CacheManager.getInstance().addCache(name);
            cache = CacheManager.getInstance().getCache(name);
        }
        Element element = new Element(key, object);
        cache.put(element);
    }

    /**
     * 移出缓存
     *
     * @param name 缓存名
     */
    public static void remove(String name) {
        CacheManager.getInstance().removeCache(name);
    }

    public static void remove(String name, String key) {
        Cache cache = CacheManager.getInstance().getCache(name);
        cache.remove(key);
    }

}
