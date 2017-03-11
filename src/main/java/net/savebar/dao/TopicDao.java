package net.savebar.dao;

import net.savebar.bean.Bar;
import net.savebar.bean.Topic;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by hxy on 2017/3/11.
 */
public interface TopicDao {

    /**
     * 保存
     *
     * @param topic Topic
     * @return 主键long
     */
    @CacheEvict(value = "Topic", allEntries = true)
    long save(Topic topic);

    /**
     *
     * @return List
     */
    @Cacheable(value = "Topic", key = "#root.methodName")
    List<Bar> list();

    /**
     * Visitor
     *
     * @param topicId topicId
     * @return Topic
     */
    @Cacheable(value = "Topic", key = "#root.methodName+'_'+#root.args[0]")
    Topic find(long topicId);
}
