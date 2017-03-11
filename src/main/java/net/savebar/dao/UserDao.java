package net.savebar.dao;

import net.savebar.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表
 * Created by hxy on 16/9/4.
 */

@Repository
public interface UserDao {

    /**
     * 列出所有的用户
     * 这个方法不做缓存
     *
     * @return List
     */
    @Cacheable(value = "User", key = "#root.methodName")
    List<User> list();

}
