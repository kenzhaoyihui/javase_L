package yzhao.spring.io.codestylething;

public class StudentMarks {
    private Integer age;
    private String name;
    private Integer id;
    private Integer marks;
    private Integer year;
    private Integer sid;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMarks() {
        return marks;
    }

    public Integer getSid() {
        return sid;
    }

    public Integer getYear() {
        return year;
    }
}
