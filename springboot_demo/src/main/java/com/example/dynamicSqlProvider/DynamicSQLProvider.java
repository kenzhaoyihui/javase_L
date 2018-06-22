package com.example.dynamicSqlProvider;

import org.apache.ibatis.jdbc.SQL;

public class DynamicSQLProvider {

    public String getFindUserByUsernameSQL() {
        return "select * from system_user where username=#{username}";
    }

    public String getGoodFindUserByUsernameSQL() {
        return new SQL(){
            {
                SELECT("*");
                FROM("system_user");
                WHERE("username=#{username}");
            }
        }.toString();
    }
}
