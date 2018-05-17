package cn.edu.yzhao.mybatis.model;

import cn.edu.yzhao.mybatis.consts.GenderEnum;

public class Student {
    private String name;
    private int age;
    private String number;
    private GenderEnum gender;

    public Student(){}

    public Student(String name, int age, String number, GenderEnum gender){
        this.name = name;
        this.age = age;
        this.number = number;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }
}
