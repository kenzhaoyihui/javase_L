package springboot_mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import springboot_mybatis.bean.Account;

import java.util.List;

//@Repository
@Mapper
public interface AccountDao {

    @Insert("insert into account(name, money) values (#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name=#{name}, money=#{money} where id=#{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    @Delete("delete from account where id=#{id}")
    int delete(int id);

    @Select("select * from account")
    List<Account> findAccountList();

    @Select("select id, name, money from account where id=#{id}")
    Account findAccountById(@Param("id") int id);
}
