package yzhao.spring.io.codestylething;

import yzhao.spring.io.daospring.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    public void setDataSource(DataSource ds);

    public void create(String name, Integer age, Integer marks, Integer year);

    public List<StudentMarks> listStudent();

}
