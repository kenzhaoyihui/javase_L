package yzhao.spring.io.codestylething;

import org.springframework.jdbc.core.RowMapper;
import yzhao.spring.io.daospring.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarksMapper implements RowMapper{
    @Override
    public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException{
        //return null;
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setAge(rs.getInt("age"));
        studentMarks.setId(rs.getInt("id"));
        studentMarks.setMarks(rs.getInt("marks"));
        studentMarks.setName(rs.getString("name"));
        studentMarks.setYear(rs.getInt("year"));
        studentMarks.setSid(rs.getInt("sid"));

        return studentMarks;
    }
}
