package com.hdm.controller;

import com.hdm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @Description
 * @Author HDM
 * @Date 2022-03-20 12:11
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("test hello");
        helloService.test();
        return "hello world";
    }
}
