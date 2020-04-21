package com.itmayiedu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "baseCache")
public interface IUserDao {

    @Insert("insert into uuid values (null)")
    void insertUUID();

    @Select("select last_insert_id()")
    Long getUUID();

    @Insert("insert into ${tableName} value (#{id},#{name},#{pwd})")
    void InsertUser(String tableName, long id, String name, String pwd);

    @Cacheable
    @Select("select name from #{tableName} where id = #{id}")
    String getUserName(String tableName, long id);
}
