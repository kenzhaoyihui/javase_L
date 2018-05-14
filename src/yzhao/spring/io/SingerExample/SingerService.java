package yzhao.spring.io.SingerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;


public class SingerService {
    //@Inject
    private Singer singer;

    public Singer getSinger() {
        return singer;
    }

    //@Resource(name="operaSinger")
    @Inject
    public void setSinger(@Named("metalSinger") Singer singer) {
        this.singer = singer;
    }

    public SingerService(){}

    public SingerService(Singer singer){
        this.singer = singer;
    }

    public void ss(){
        System.out.println(singer.sing("hello"));
    }
}
