package net.savebar.dao;

import net.savebar.bean.Visitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * VisitorDao
 * <p>
 * Created by hxy on 2015/9/1.
 */
@Repository
public interface VisitorDao {

    /**
     * 保存
     *
     * @param visitor visitor对象
     * @return 主键long
     */
    @CacheEvict(value = "Visitor", allEntries = true)
    long save(Visitor visitor);

    /**
     * 根据id来删除Visitor对象
     *
     * @param visitorId 对象id
     * @return long
     */
    @CacheEvict(value = "Visitor", allEntries = true)
    long delete(long visitorId);


    /**
     * Visitor
     *
     * @param visitorId visitor的id
     * @return visitor
     */
    @Cacheable(value = "Visitor", key = "#root.methodName+'_'+#root.args[0]")
    Visitor find(long visitorId);

    /**
     * 更新
     *
     * @param visitor 访客对象
     * @return long 返回受影响的列
     */
    @CacheEvict(value = "Visitor", allEntries = true)
    long update(Visitor visitor);


    /**
     * 统计所有的访客数
     *
     * @return long
     */
    @Cacheable(value = "Visitor", key = "#root.methodName")
    long count();

    /**
     * 分页列出文章
     *
     * @param offset offset
     * @param limit  limit
     * @return list
     */
    @Cacheable(value = "Visitor", key = "#root.methodName+'_'+#root.args[0]+'_'+#root.args[1]")
    List<Visitor> listByPage(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 统计一个时间段的访问量
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return long
     */
    @Cacheable(value = "Visitor", key = "#root.methodName+'_'+#root.args[0]+'_'+#root.args[1]")
    long countByDate(@Param("start_time") Date start, @Param("end_time") Date end);


    /**
     * 批量插入保存
     *
     * @param visitorList visitorList
     */
    @CacheEvict(value = "Visitor", allEntries = true)
    void batchSave(@Param("visitorList") List<Visitor> visitorList);

}
