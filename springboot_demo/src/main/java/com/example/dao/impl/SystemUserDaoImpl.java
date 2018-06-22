package com.example.dao.impl;


import com.example.bean.SystemUser;
import com.example.dao.SystemUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.List;

//@Repository("systemUserDao")
@Repository("systemUserDao")
public class SystemUserDaoImpl implements SystemUserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    static class UserRowMapper implements RowMapper<SystemUser> {
        @Override
        public SystemUser mapRow(ResultSet resultSet, int i) throws SQLException{
            //return null;

            SystemUser systemUser = new SystemUser();
            systemUser.setUuid(resultSet.getInt("uuid"));
            systemUser.setUsername(resultSet.getString("username"));
            systemUser.setPassword(resultSet.getString("password"));
            systemUser.setIsRoot(resultSet.getString("isRoot"));
            systemUser.setRegisterDate(new Date(resultSet.getDate("registerDate").getTime()));
            systemUser.setStatus(resultSet.getInt("status"));

            return systemUser;
        }
    }

    @Override
    public SystemUser findUserByUsername(String username) {
        //return null;
        List<SystemUser> list = jdbcTemplate.query(
                "select * from system_user where username=?",
                new Object[]{username},
                new int[]{Types.VARCHAR},
                new UserRowMapper()
        );
        if(null!=list&&!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<SystemUser> findAllUser() {
        //return null;
        return jdbcTemplate.query("select * from system_user",new UserRowMapper());
    }

    @Override
    public void saveUsers(SystemUser user) {
        //return null;
        final String sql = "insert into system_user(username,password,isRoot,registerDate,status) values(?,?,?,?,?)";
        //user.setUuid(UUID.randomUUID().toString().replace("-",""));
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                //ps.setString(1, user.getUuid());
                ps.setString(1, user.getUsername());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getIsRoot());
                ps.setDate(4,new java.sql.Date(user.getRegisterDate().getTime()));
                ps.setInt(5,user.getStatus());
                return ps;
            }
        });
//        return user.getUuid().toString();
    }

    @Override
    public void deleteUserByUUID(Integer uuid) {
        jdbcTemplate.update("delete from system_user where uuid=?",
                new Object[]{uuid},
                new int[]{Types.VARCHAR});
    }

    @Override
    public void updateUser(SystemUser user) {
        jdbcTemplate.update(
                "update system_user set password=?,status=? where username=?",
                new Object[]{user.getPassword(), user.getStatus(), user.getUsername()});
    }

    @Override
    public void deleteUserByUsername(String username) {
        jdbcTemplate.update(
                "delete from system_user where username=?",
                new Object[]{username},
                new int[]{Types.VARCHAR}
        );
    }
}
