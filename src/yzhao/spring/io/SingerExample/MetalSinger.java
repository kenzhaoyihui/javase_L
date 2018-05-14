package yzhao.spring.io.SingerExample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class MetalSinger implements Singer{
    @Override
    public String sing(String s){
        return "I am singing with DIO voice: " + s;
    }
}
