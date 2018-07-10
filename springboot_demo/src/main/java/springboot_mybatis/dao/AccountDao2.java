package springboot_mybatis.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao2 {
    int update(@Param("money") double money, @Param("id") int id);
}
