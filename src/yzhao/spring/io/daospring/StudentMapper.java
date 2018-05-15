package yzhao.spring.io.daospring;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        //return null;
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
