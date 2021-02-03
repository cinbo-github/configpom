package com.cinbo.testbean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("initBeanTest1")
public class InitBeanTest implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextRefreshedEvent){
            System.out.println("sprint 初始化");
        }
    }
}
