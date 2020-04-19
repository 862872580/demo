package shiro.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import shiro.beans.User;

@CacheConfig(cacheNames = "baseCache")
@Mapper
public interface IUserDao {

    @Cacheable
    @Select("select * from user where name=#{name}")
    public User findByName(String name);
}
