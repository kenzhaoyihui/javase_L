package yzhao.spring.io.daospring;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";
        jdbcTemplate.update(SQL, name, age);
        System.out.println("Created Record name = " + name + " Age = " + age);
        return;
    }

    @Override
    public void update(Integer id, Integer age) {
        String SQL = "update Student set age=? where id=?";
        jdbcTemplate.update(SQL, age, id);
        System.out.println("Updated Record with ID= " + id);
        return;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from Student where id=?";
        jdbcTemplate.update(SQL,id);
        System.out.println("Deleted Record with ID= " + id);
    }

    @Override
    public Student getStudent(Integer id) {
        String SQL = "select * from Student where id=?";
        Student student = (Student) jdbcTemplate.queryForObject(SQL, new Object[] {id}, new StudentMapper());
        return student;
        //return null;
    }

    @Override
    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        return students;
        //return null;
    }
}
