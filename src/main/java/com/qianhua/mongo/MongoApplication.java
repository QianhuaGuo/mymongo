package com.qianhua.mongo;

import com.qianhua.mongo.config.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;

@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
        Object mainConfig = ac.getBean("mainConfig");

//        SpringApplication.run(MongoApplication.class, args);
    }

}
