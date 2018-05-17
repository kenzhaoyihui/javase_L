package yzhao.spring.io.codestylething;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import yzhao.spring.io.daospring.StudentMapper;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    public void create(String name, Integer age, Integer marks, Integer year) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        //Track the things
        TransactionStatus status = transactionManager.getTransaction(def);

        try{
            String sql1 = "insert into Student(name, age) values (?, ?)";
            jdbcTemplate.update(sql1, name, age);

            String sql2 = "select max(id) from Student";
            Integer sid = (Integer) jdbcTemplate.queryForObject(sql2, new Object[] {}, java.lang.Integer.class);
//            List<Integer> sidlist = jdbcTemplate.query(sql2, new StudentMarksMapper());
//            int sid = sidlist.get(0);

            String sql3 = "insert into Marks(sid, marks, year) values (?,?,?)";
            jdbcTemplate.update(sql3, sid, marks, year);

            System.out.println("Created Name=" + name + " , Age=" + age );
            transactionManager.commit(status);
        }catch (DataAccessException e){
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return;
    }

    @Override
    public List<StudentMarks> listStudent() {
        //return null;
        String sql = "select * from Student, Marks where Student.id=Marks.sid";

        List<StudentMarks> studentMarks = jdbcTemplate.query(sql, new StudentMarksMapper());
        return studentMarks;
    }
}
