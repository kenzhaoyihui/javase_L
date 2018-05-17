package yzhao.mybatis.film;

public class Film {
    private Long id;
    private String fname;

    public Film(){}

    public String getFname() {
        return fname;
    }

    public Long getId() {
        return id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
