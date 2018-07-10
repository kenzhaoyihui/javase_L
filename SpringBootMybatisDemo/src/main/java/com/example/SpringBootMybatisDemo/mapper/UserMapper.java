package com.example.SpringBootMybatisDemo.mapper;

import com.example.SpringBootMybatisDemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 创建人：thj
 * 创建时间： 2018/6/26 9:28
 * 用途：
 */

//@Repository
public interface UserMapper {

   // @Select("SELECT * FROM USER WHERE id = #{id}")
   User getUserById(Integer id);

   // @Select("SELECT * FROM USER")
    public List<User> getUserList(String name,int page, int limit);

   // @Insert("insert into USER(name, age) values(#{username}, #{age})")
    public int add(User user);

   // @Update("UPDATE USER SET name = #{user.name} , age = #{user.age} WHERE id = #{id}")
   public int update(User user);

   // @Delete("DELETE FROM USER WHERE id = #{id} ")
    public int delete(Integer id);


    int getUserCount();
}