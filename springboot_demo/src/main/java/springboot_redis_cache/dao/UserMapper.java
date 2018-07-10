package springboot_redis_cache.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import springboot_redis_cache.domain.User;

@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    @Insert("insert into user(name, age) values(#{name}, #{age}")
    int addUser(@Param("name") String name, @Param("age") String age);


    @Select("select * from user where id=#{id}")
    @Cacheable(key = "#p0")
    User findById(@Param("id") String id);

    @CachePut(key = "#p0")
    @Update("update user set name=#{name}, age=#{age} where id=#{id}")
    void updateById(@Param("id") String id, @Param("name") String name, @Param("age") String age);

    @CacheEvict(key = "#p0", allEntries = true)
    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id") String id);
}
