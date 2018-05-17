package cn.edu.yzhao.mybatis.consts;

public enum GenderEnum {
    MALE("man"), FEMALE("women");

    private String desc;

    //The constructor method is must be private
    private GenderEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
