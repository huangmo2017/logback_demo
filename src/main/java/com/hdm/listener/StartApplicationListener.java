package com.hdm.listener;

import com.hdm.log.LoggerBuilder;
import com.hdm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author HDM
 * @Date 2022-03-20 15:42
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    HelloService helloService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        String logPath = helloService.getLogPathByRequestId("122");
        LoggerBuilder.setLogger(logPath);
    }
}
