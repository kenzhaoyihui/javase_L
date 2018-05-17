package cn.edu.yzhao.mybatis.dao;

import cn.edu.yzhao.mybatis.model.Student;

public interface StudentDAO {
    public void insertStudent(Student student);

    public void deleteStudentByNumber(String number);

    public void updateStudentByNumber(Student student);


    public Student getStudentByNumber(String number);
}
