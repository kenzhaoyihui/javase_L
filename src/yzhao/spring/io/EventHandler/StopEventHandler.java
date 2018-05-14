package yzhao.spring.io.EventHandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStoppedEvent;


public class StopEventHandler implements ApplicationListener<ContextStoppedEvent>{

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStopEventReceived Received...");
    }
}
