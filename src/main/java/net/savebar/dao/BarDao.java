package net.savebar.dao;

import net.savebar.bean.Bar;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by hxy on 2017/3/11.
 */
public interface BarDao {

    /**
     * 保存
     *
     * @param bar Bar
     * @return 主键long
     */
    @CacheEvict(value = "Bar", allEntries = true)
    long save(Bar bar);

    /**
     *
     * @return List
     */
    @Cacheable(value = "Bar", key = "#root.methodName")
    List<Bar> list();

    /**
     * Visitor
     *
     * @param barId barId
     * @return Bar
     */
    @Cacheable(value = "Bar", key = "#root.methodName+'_'+#root.args[0]")
    Bar find(long barId);
}
