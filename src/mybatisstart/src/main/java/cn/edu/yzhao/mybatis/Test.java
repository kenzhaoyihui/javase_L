package cn.edu.yzhao.mybatis;

import cn.edu.yzhao.mybatis.consts.GenderEnum;
import cn.edu.yzhao.mybatis.dao.StudentDAO;
import cn.edu.yzhao.mybatis.model.Student;
import cn.edu.yzhao.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test {
    private static SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

    public static void main(String[] args){
        insertStudent(new Student("lj", 22, "1234", GenderEnum.MALE));
        insertStudent(new Student("zzz", 23, "12345", GenderEnum.MALE));

        getStudentByNumber("1234");
        getStudentByNumber("12345");

        updateStudentByNumber(new Student("lljj", 24, "1234", GenderEnum.FEMALE));

        deleteStudentByNumber("12345");

        getStudentByNumber("1234");


    }

    public static void insertStudent(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);

//        Student student = new Student();
//        student.setAge(60);
//        student.setName("zyh");
//        student.setNumber("123456");
//        student.setGender(GenderEnum.MALE);

        studentDAO.insertStudent(student);
        sqlSession.commit();
    }

    public static void updateStudentByNumber(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        ///Student student = studentDAO.getStudentByNumber(number);
        //student.setAge(23);
        studentDAO.updateStudentByNumber(student);
        sqlSession.commit();
    }

    public static void deleteStudentByNumber(String number){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        studentDAO.deleteStudentByNumber(number);
        sqlSession.commit();
    }

    public static void getStudentByNumber(String number){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);

        Student student = studentDAO.getStudentByNumber(number);

        System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + " , Sex: " + student.getGender() + " , Number: " + student.getNumber());


    }
}
