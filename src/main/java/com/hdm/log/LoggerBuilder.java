package com.hdm.log;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.LoggerFactory;

public class LoggerBuilder {

    public static Logger LOGGER;

    public static void setLogger(String logPath) {
        LOGGER = build(logPath);
    }

    private static Logger build(String logPath) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        Logger logger = context.getLogger("FILE-Scenario");
        logger.setAdditive(false);
        RollingFileAppender appender = new RollingFileAppender();

        appender.setContext(context);
        appender.setName("FILE-Scenario");
        appender.setFile(logPath);
        appender.setAppend(true);
        appender.setPrudent(false);
        SizeAndTimeBasedRollingPolicy policy = new SizeAndTimeBasedRollingPolicy();

        policy.setMaxFileSize(FileSize.valueOf("128MB"));
        policy.setFileNamePattern(logPath + "/.%d{yyyy-MM-dd}.%i");
        policy.setMaxHistory(15);
        policy.setTotalSizeCap(FileSize.valueOf("32GB"));
        policy.setParent(appender);
        policy.setContext(context);
        policy.start();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern("%d %p (%file:%line\\)- %m%n");
        encoder.start();

        PatternLayoutEncoder encoder1 = new PatternLayoutEncoder();
        encoder1.setContext(context);
        encoder1.setPattern("%d %p (%file:%line\\)- %m%n");
        encoder1.start();

        appender.setRollingPolicy(policy);
        appender.setEncoder(encoder);
        appender.start();

        /*设置动态日志控制台输出*/
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(context);
        consoleAppender.setEncoder(encoder1);
        consoleAppender.start();
        logger.addAppender(consoleAppender);

        logger.addAppender(appender);

        return logger;
    }
}