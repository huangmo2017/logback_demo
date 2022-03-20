package com.hdm.service;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Description
 * @Author HDM
 * @Date 2022-03-20 15:45
 */
@Service
public class HelloService {

    public String getLogPathByRequestId(String requestId) {
        return "D:\\IdeaProjects\\logback_demo\\log2022-3-20" + File.separator + "ScenarioDownloader_" + requestId + ".log";
        //return "test";
    }

}
