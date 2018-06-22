package com.example.mapper;

import com.example.bean.SystemUser;
import com.example.dynamicSqlProvider.DynamicSQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface SystemUserMapper {

    //@Select("select * from system_user where username=#{username}") //Method1
    @SelectProvider(type = DynamicSQLProvider.class, method = "getGoodFindUserByUsernameSQL")
    SystemUser findUserByUsername(String username);


    //@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。

    @Select("select * from system_user")
    @Results({
            @Result(property = "uuid", column = "uuid", javaType = Integer.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "isRoot", column = "isRoot", javaType = String.class),
            @Result(property = "registerDate", column = "registerDate", javaType = java.util.Date.class),
            @Result(property = "status", column = "status", javaType = Integer.class),
    })
    List<SystemUser> findAllUsers();

    @Insert("insert into system_user(username, password, isRoot, status, registerDate) " +
            "values(#{username}, #{password}, #{isRoot}, #{status}, #{registerDate})")
    void saveUser(SystemUser user);

    @Delete("delete from system_user where username=#{username}")
    void deleteUserByUsername(String username);

    @Update("update system_user set password=#{password}, status=#{status} where username=#{username}")
    void updateUser(SystemUser user);

    @Delete("delete from system_user where uuid=#{uuid}")
    void deleteUserByUUID(Integer uuid);
}
