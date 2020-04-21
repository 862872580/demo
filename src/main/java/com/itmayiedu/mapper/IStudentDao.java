package com.itmayiedu.mapper;

import com.itmayiedu.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "baseCache")
public interface IStudentDao {

    @Select("select * from student where id=#{id}")
    @Cacheable
    Student selectStudentById(@Param("id") int id);
}
